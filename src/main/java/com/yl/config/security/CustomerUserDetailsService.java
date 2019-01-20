package com.yl.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.yl.dao.AdminUserDao;
import com.yl.modle.AdminUser;

@Component
public class CustomerUserDetailsService implements UserDetailsService{
	@Autowired
	private AdminUserDao adminUserDao;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//通过dao查找当前用户名对应的用户
		AdminUser admin = adminUserDao.queryAdminUserByUserName(username);
        if (admin == null){
            throw new UsernameNotFoundException("This username: "+username+"is not exist");
        }
        //返回一个定制的UserDetails
        //AuthorityUtils.createAuthorityList(admin.getRole())就是将我们该用户所有的权限（角色）生成一个集合
        return new CustomerUserDetails(admin, AuthorityUtils.createAuthorityList(admin.getRoleId().toString()));
	}

}
