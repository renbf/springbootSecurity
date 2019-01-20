
package com.yl.dao;
import com.yl.modle.AdminUser;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
/**
 * @author rbf
 * @createdate 2018/12/31 06:11
 * @desriction
 */
 @Mapper
public interface AdminUserDao {


	public List<AdminUser> queryAdminUserAll();

	public Integer addAdminUser(AdminUser adminUser);
	
	public AdminUser queryAdminUserByUserName(@Param("userName") String userName);
	
	//public Integer deleteAdminUserById(Integer id);
	
	//public Integer updateAdminUser(AdminUser classNameField);
}
