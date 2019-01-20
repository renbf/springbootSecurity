package com.yl.modle;

import java.io.Serializable;
/**
 * @author rbf
 * @createdate 2018/12/31 06:11
 * @desriction
 */
public class Permission implements Serializable {
	/**
	*serialVersionUID
	*/
	private static final long serialVersionUID = -2340557932235738712L;
	/**
	*权限id
	*/
	private Integer permissionId;
	/**
	*权限url
	*/
	private String permissionUrl;
	/**
	*权限描述
	*/
	private String permissionDeac;

	public Integer getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}
	public String getPermissionUrl() {
		return permissionUrl;
	}
	public void setPermissionUrl(String permissionUrl) {
		this.permissionUrl = permissionUrl;
	}
	public String getPermissionDeac() {
		return permissionDeac;
	}
	public void setPermissionDeac(String permissionDeac) {
		this.permissionDeac = permissionDeac;
	}
}
