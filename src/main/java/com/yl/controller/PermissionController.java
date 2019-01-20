package com.yl.controller;

import com.yl.modle.Permission;
import com.yl.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author rbf
 * @createdate 2018/12/31 06:11
 * @desriction
 */
@Controller
public class PermissionController {

	@Autowired
	private IPermissionService permissionService;
	
	@RequestMapping(value = "/getPermissionList")
	public ModelAndView getPermissionList(HttpServletRequest request) {
        List<Permission> list = permissionService.queryPermissionAll();
        ModelAndView mv = new ModelAndView("permission");
        Map<String, Object> result = new HashMap<>();
        result.put("list", list);
        result.put("name", "1fds");
        mv.addAllObjects(result);
        return mv;
	}
	
	@RequestMapping(value = "/addPermission")
	@ResponseBody
	public String addPermission(HttpServletRequest request,Permission permission) {
        Integer count = permissionService.addPermission(permission);
        return "添加成功";
	}
}
