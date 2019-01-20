package com.yl.service.impl;


import com.yl.dao.AdminUserDao;
import com.yl.modle.AdminUser;
import com.yl.service.IAdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * @author rbf
 * @createdate 2018/12/31 06:11
 * @desriction
 */
@Service
public class AdminUserServiceImpl implements IAdminUserService{

	@Autowired
	private AdminUserDao adminUserDao;

	@Override
	public List<AdminUser> queryAdminUserAll(){
        return adminUserDao.queryAdminUserAll();
	}
	
	@Override
	public Integer addAdminUser(AdminUser adminUser){
        return adminUserDao.addAdminUser(adminUser);
	}
}
