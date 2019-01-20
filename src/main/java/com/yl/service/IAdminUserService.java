package com.yl.service;

import java.util.List;
import com.yl.modle.AdminUser;
/**
 * @author rbf
 * @createdate 2018/12/31 06:11
 * @desriction
 */
public interface IAdminUserService {

	public List<AdminUser> queryAdminUserAll();
	
	public Integer addAdminUser(AdminUser adminUser);
}
