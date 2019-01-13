package com.hb.spr.SprBootTest.service;

import java.util.List;

import com.hb.spr.SprBootTest.model.User;

public interface UserService {
    User get(User user);
    List<User> all();
    User getById(String id);
    User getFirstByAccountAndPassword(String name, String password);
    List<User> query(User user);
    User findOneByName(String name);
    void add(User user) throws Exception ;
}
