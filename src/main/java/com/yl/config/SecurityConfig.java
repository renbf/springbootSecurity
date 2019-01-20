package com.yl.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.yl.config.security.CustomerLoginSuccessHandler;
import com.yl.config.security.CustomerUserDetails;
import com.yl.config.security.CustomerUserDetailsService;

//注解开启Spring Security的功能
//WebSecurityConfigurerAdapter:重写它的方法来设置一些web的安全西街
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	private static final Logger log = LoggerFactory.getLogger(SecurityConfig.class);
	@Autowired
    private CustomerUserDetailsService userDetailsService;
	@Autowired
    private CustomerLoginSuccessHandler successHandler;
	@Autowired
    private BCryptPasswordEncoder encoder;

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() { //登出处理
        return new LogoutSuccessHandler() {
            @Override
            public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                try {
                	CustomerUserDetails user = (CustomerUserDetails) authentication.getPrincipal();
                    log.info("USER : " + user.getUsername() + " LOGOUT SUCCESS !  ");
                } catch (Exception e) {
                    log.info("LOGOUT EXCEPTION , e : " + e.getMessage());
                }
                httpServletResponse.sendRedirect("/login");
            }
        };
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/assets/**"); //不过滤静态资源
        super.configure(web);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService) //注册自己定制的UserDetailsService
                .passwordEncoder(encoder); // 配置密码加密器
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {

    	http.csrf().disable();
        http.authorizeRequests().
                antMatchers("/static/**").permitAll().anyRequest().authenticated().
                and().formLogin().loginPage("/login").permitAll().successHandler(successHandler).permitAll().
                and().logout().permitAll().invalidateHttpSession(true).
                deleteCookies("JSESSIONID").logoutSuccessHandler(logoutSuccessHandler()).
                and().sessionManagement().maximumSessions(10).expiredUrl("/login");
        
//    	http.csrf().disable();
//        http.authorizeRequests().
//                antMatchers("/static/**").permitAll().anyRequest().authenticated().
//                and().formLogin().loginPage("/login").permitAll().successHandler(successHandler).
//                and().logout().permitAll().invalidateHttpSession(true).
//                deleteCookies("JSESSIONID").logoutSuccessHandler(logoutSuccessHandler()).
//                and().sessionManagement().maximumSessions(10).expiredUrl("/login");
        
//        http
//                .authorizeRequests() //获取请求方面的验证器
//                    .antMatchers("/", "/error").permitAll()// 访问当前配置的路径可通过认证
//                    //访问其他路径需要认证和角色权限
//                    .anyRequest().hasAnyAuthority("1")
//                    .anyRequest().authenticated()
//                    .and()
//                .formLogin() //获取登录认证验证器
//                    .loginPage("/login") //注册自定义的登录页面URL
//                    .failureForwardUrl("/login") //登录失败后以登录时的请求转发到该链接
//                    .successHandler(successHandler) //登录成功后调用该处理器
//                    .permitAll() //登录请求给予通过认证
//                    .and()
//                .logout() //推出登录
//                    .logoutSuccessUrl("/login") //退出后访问URL
//                    .and()
//                .csrf().disable(); //关闭csrf，默认开启

    }
    
	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/css/**", "/").permitAll()		
				.antMatchers("/**").hasRole("USER")			
				.and()
			.formLogin()
				.loginPage("/login").failureUrl("/login-error");	
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
				.withUser("user").password("password").roles("USER");
		//在内存中创建了一个用户，该用户的名称为user，密码为password，用户角色为USER
	}*/
}
