package com.yl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yl.modle.AdminUser;
import com.yl.service.IAdminUserService;
/**
 * @author rbf
 * @createdate 2018/12/31 06:11
 * @desriction
 */
@Controller
public class AdminUserController {

	@Autowired
	private IAdminUserService adminUserService;
	
	@RequestMapping(value = "/getAdminUserList")
	public ModelAndView getAdminUserList(HttpServletRequest request) {
        List<AdminUser> list = adminUserService.queryAdminUserAll();
        ModelAndView mv = new ModelAndView("adminUser");
        Map<String, Object> result = new HashMap<>();
        result.put("list", list);
        result.put("name", "1fds");
        mv.addAllObjects(result);
        return mv;
	}
	
	@RequestMapping(value = "/addAdminUser")
	@ResponseBody
	public String addAdminUser(HttpServletRequest request,AdminUser adminUser) {
        Integer count = adminUserService.addAdminUser(adminUser);
        return "添加成功";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }
	@RequestMapping("/")
    public String root() {
        return "index";
    }
}
