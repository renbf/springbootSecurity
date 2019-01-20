package com.yl.config.security;

import java.util.Collection;

import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.yl.modle.AdminUser;

public class CustomerUserDetails implements UserDetails{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3538046795079515920L;
	
	private AdminUser admin = null;
    //存放权限的集合
    private final Collection<? extends GrantedAuthority> authorities;
    private final boolean accountNonExpired;
    private final boolean accountNonLocked;
    private final boolean credentialsNonExpired;
    private final boolean enabled;
    
    public CustomerUserDetails(AdminUser admin, Collection<? extends GrantedAuthority> authorities) {
        this(admin, true, true, true,true,authorities);
    }
    public CustomerUserDetails(AdminUser admin, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        if(admin.getAdminUserName() != null && !"".equals(admin.getAdminUserName()) && admin.getPassword() != null) {
            this.admin = admin;
            this.enabled = enabled;
            this.accountNonExpired = accountNonExpired;
            this.credentialsNonExpired = credentialsNonExpired;
            this.accountNonLocked = accountNonLocked;
            this.authorities = authorities;
        } else {
            throw new IllegalArgumentException("Cannot pass null or empty values to constructor");
        }
    }
    
    public AdminUser getAdmin() {
        return admin;
    }

    public void setAdmin(@NotNull AdminUser admin) {
        this.admin = admin;
    }

    public boolean equals(Object rhs) {
        return rhs instanceof CustomerUserDetails && this.getUsername().equals(((CustomerUserDetails) rhs).getUsername());
    }

    public int hashCode() {
        return this.getUsername().hashCode();
    }
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}
	@Override
	public String getPassword() {
		return this.admin.getPassword();
	}
	@Override
	public String getUsername() {
		return this.admin.getAdminUserName();
	}
	@Override
	public boolean isAccountNonExpired() {
		 return this.accountNonExpired;
	}
	@Override
	public boolean isAccountNonLocked() {
		 return this.accountNonLocked;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return this.credentialsNonExpired;
	}
	@Override
	public boolean isEnabled() {
		 return this.enabled;
	}
    
}
