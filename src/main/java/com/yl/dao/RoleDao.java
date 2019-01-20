
package com.yl.dao;
import com.yl.modle.Role;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
/**
 * @author rbf
 * @createdate 2018/12/31 06:11
 * @desriction
 */
 @Mapper
public interface RoleDao {


	public List<Role> queryRoleAll();

	public Integer addRole(Role role);
	
	//public Integer deleteRoleById(Integer id);
	
	//public Integer updateRole(Role classNameField);
}
