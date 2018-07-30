package com.hb.spr.SprBootTest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hb.spr.SprBootTest.cfg.hello.UserInfo;
import com.hb.spr.SprBootTest.model.User;

@Controller
@RequestMapping("/hello")
public class HelloController {
	private static final Logger log = LoggerFactory
			.getLogger(HelloController.class);

	@RequestMapping("/say")
    @ResponseBody
    public String say(){
		String path = HelloController.class.getResource("/files/aaa.txt").getPath();
    	log.info(">>>>文件路径：" + path);
        return "hello world!";
    }
	@Autowired
	private UserInfo userInfo;

	@ResponseBody
	@RequestMapping("/user/{userId}")
	public User user(@PathVariable("userId") String userId) {
		if ("1".equals(userId)) {
			User u = new User();
			u.setName(userInfo.getName());
			return u;
		} else {
			return null;
		}
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}
