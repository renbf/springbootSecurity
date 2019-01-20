package com.yl.modle;

import java.io.Serializable;
/**
 * @author rbf
 * @createdate 2018/12/31 06:11
 * @desriction
 */
public class Role implements Serializable {
	/**
	*serialVersionUID
	*/
	private static final long serialVersionUID = -2340557932235738712L;
	/**
	*角色id
	*/
	private Integer roleId;
	/**
	*角色名称
	*/
	private String roleName;
	/**
	*角色类型
	*/
	private Integer type;
	/**
	*权限id
	*/
	private Integer permissionId;

	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}
}
