package com.hb.spr.SprBootTest.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hb.spr.SprBootTest.model.User;
import com.hb.spr.SprBootTest.service.UserService;

@Controller
@RequestMapping("/security")
public class SecurityController {

	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	@ResponseBody
	public String login(HttpServletRequest request) {
		// 获取登陆参数
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");

		// 验证用户信息
		User user = userService.getFirstByAccountAndPassword(username,
				userpwd);

		// 如果用户信息验证成功，则初始化用户信息，否则返回错误页面
		if (user != null) {
			//初始化
			return "success";
		}

		return "error";
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
