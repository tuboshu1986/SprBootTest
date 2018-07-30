package com.hb.spr.SprBootTest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hb.spr.SprBootTest.model.User;

public interface UserRepository extends JpaRepository<User, String>{
    User getFirst1ById(String id);
    List<User> getByNameLike(String name);
    User getFirst1ByAccountAndPassword(String name, String password);
}
