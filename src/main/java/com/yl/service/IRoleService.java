package com.yl.service;

import java.util.List;
import com.yl.modle.Role;
/**
 * @author rbf
 * @createdate 2018/12/31 06:11
 * @desriction
 */
public interface IRoleService {

	public List<Role> queryRoleAll();
	
	public Integer addRole(Role role);
}
