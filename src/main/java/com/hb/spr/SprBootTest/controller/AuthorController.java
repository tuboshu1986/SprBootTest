package com.hb.spr.SprBootTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hb.spr.SprBootTest.cfg.author.AuthorInfo;

@Controller
@RequestMapping("/author")
public class AuthorController {

    /**
     * 获取作者信息
     */
    @RequestMapping("/info")
    @ResponseBody
    public Object info(){
        return AuthorInfo.getInstance();
    }
}
