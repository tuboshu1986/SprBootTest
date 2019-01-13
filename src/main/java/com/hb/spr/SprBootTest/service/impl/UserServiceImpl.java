package com.hb.spr.SprBootTest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.security.MD5Encoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hb.spr.SprBootTest.model.User;
import com.hb.spr.SprBootTest.repository.UserRepository;
import com.hb.spr.SprBootTest.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	public static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
    public static List<User> users = new ArrayList<User>();
    
    static {
        User u1 = new User();
        u1.setId("1");
        u1.setAccount("aaa");
        u1.setName("啊啊啊");
        u1.setPassword(new BCryptPasswordEncoder().encode("123"));
        users.add(u1);

        User u2 = new User();
        u2.setId("2");
        u2.setAccount("bbb");
        u2.setName("不不不");
        u2.setPassword("123");
        users.add(u2);

        User u3 = new User();
        u3.setId("3");
        u3.setAccount("ccc");
        u3.setName("吃吃吃");
        u3.setPassword(MD5Encoder.encode("123".getBytes()));
        users.add(u3);
    }

    @Autowired
    private UserRepository userRepository;

	@Override
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

	@Override
    public User getById(String id){
        return this.userRepository.getFirst1ById(id);
    }

	@Override
    public User getFirstByAccountAndPassword(String name, String password){
    	return this.userRepository.getFirst1ByAccountAndPassword(name, password);
    }

	@Override
	public List<User> query(User user) {
		return this.userRepository.getByNameLike(user.getName());
	}

    public User findOneByName(String name){
    	logger.debug(">>>>查询用户信息：" + name);
        for (User u : users) {
            if(u.getName().equals(name)) {
                return u;
            }
        }
        return null;
    }

	@Override
	public void add(User user) throws Exception {
		if(user != null && this.get(user) == null){
			users.add(user);
			return;
		}
		throw new Exception("新增失败");
	}

    public UserRepository getUserRepository()
    {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

}
