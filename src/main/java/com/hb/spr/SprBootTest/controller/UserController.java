package com.hb.spr.SprBootTest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hb.spr.SprBootTest.model.User;
import com.hb.spr.SprBootTest.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    
    @Autowired
    private UserService userService;

    @RequestMapping("/all")
    public String get(Model model){
        model.addAttribute("userInfos", userService.all());
        return "/user/list";
    }

    @RequestMapping("/get/{id}")
    public String get(@PathVariable("id") String id, Model model){
        User user = new User();
        user.setId(id);
        user = userService.get(user);
        model.addAttribute("userInfo", user);
        return "/user/info";
    }
    
    @RequestMapping("/getByName/{name}")
    @ResponseBody
    public User getById(@PathVariable String id) {
        log.info(">>>>id:" + id);
        return this.userService.getById(id);
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    
}
