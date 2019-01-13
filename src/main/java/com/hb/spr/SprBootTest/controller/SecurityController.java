package com.hb.spr.SprBootTest.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hb.spr.SprBootTest.define.HbException;
import com.hb.spr.SprBootTest.define.HbSecurityException;
import com.hb.spr.SprBootTest.model.User;
import com.hb.spr.SprBootTest.service.UserService;

@Controller
@RequestMapping("/security")
public class SecurityController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserService userService;

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/loginPage")
	public String loginPage() {
		logger.info(">>>>前往登录页面");
		return "security/login";
	}

	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model) {
		try{
			// 获取登陆参数
			String username = request.getParameter("username");
			String userpwd = request.getParameter("userpwd");
	
			if(StringUtils.isEmpty(username) || StringUtils.isEmpty(userpwd)){
				throw new HbSecurityException("请输入用户名和密码");
			}
			
			// 验证用户信息
			User user = userService.getFirstByAccountAndPassword(username, userpwd);
	
			// 如果用户信息验证成功，则初始化用户信息，否则返回错误页面
			if (user != null) {
				// 初始化
				return "redirect:/security/index";
			}else{
				throw new HbSecurityException("用户名或密码错误");
			}
		}catch(HbException e){
			e.printStackTrace();
			model.addAttribute("loginMessage", e.getMessage());
		}catch(Exception e){
			e.printStackTrace();
			model.addAttribute("loginMessage", "系统错误");
		}

		return "forward:/security/loginPage";
	}

	@RequestMapping("/exception")
	public String exceptionTest() throws HbException{
		throw new HbException("声明无效");
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
