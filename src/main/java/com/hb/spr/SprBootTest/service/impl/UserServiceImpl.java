package com.hb.spr.SprBootTest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hb.spr.SprBootTest.model.User;
import com.hb.spr.SprBootTest.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    public static List<User> users = new ArrayList<User>();
    
    static {
        User u1 = new User();
        u1.setId("1");
        u1.setAccount("aaa");
        u1.setName("啊啊啊");
        users.add(u1);

        User u2 = new User();
        u2.setId("2");
        u2.setAccount("bbb");
        u2.setName("不不不");
        users.add(u2);

        User u3 = new User();
        u3.setId("3");
        u3.setAccount("ccc");
        u3.setName("吃吃吃");
        users.add(u3);
    }
    
    public User get(User user) {
        for (User u : users) {
            if(u.getId().equals(user.getId())) {
                return u;
            }
            
        }
        return null;
    }

    @Override
    public List<User> all() {
        return users;
    }

}
