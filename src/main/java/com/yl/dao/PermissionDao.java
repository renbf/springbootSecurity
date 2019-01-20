
package com.yl.dao;
import com.yl.modle.Permission;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
/**
 * @author rbf
 * @createdate 2018/12/31 06:11
 * @desriction
 */
 @Mapper
public interface PermissionDao {


	public List<Permission> queryPermissionAll();

	public Integer addPermission(Permission permission);
	
	//public Integer deletePermissionById(Integer id);
	
	//public Integer updatePermission(Permission classNameField);
}
