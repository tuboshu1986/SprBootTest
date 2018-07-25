package com.hb.spr.SprBootTest.service;

import java.util.List;

import com.hb.spr.SprBootTest.model.User;

public interface UserService {
    User get(User user);
    List<User> all();
}
