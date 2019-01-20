package com.yl.service.impl;


import com.yl.dao.PermissionDao;
import com.yl.modle.Permission;
import com.yl.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * @author rbf
 * @createdate 2018/12/31 06:11
 * @desriction
 */
@Service
public class PermissionServiceImpl implements IPermissionService{

	@Autowired
	private PermissionDao permissionDao;

	@Override
	public List<Permission> queryPermissionAll(){
        return permissionDao.queryPermissionAll();
	}
	
	@Override
	public Integer addPermission(Permission permission){
        return permissionDao.addPermission(permission);
	}
}
