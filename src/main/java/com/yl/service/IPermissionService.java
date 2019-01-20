package com.yl.service;

import java.util.List;
import com.yl.modle.Permission;
/**
 * @author rbf
 * @createdate 2018/12/31 06:11
 * @desriction
 */
public interface IPermissionService {

	public List<Permission> queryPermissionAll();
	
	public Integer addPermission(Permission permission);
}
