package com.zmq.service.impl;

import com.zmq.dao.UserDao;
import com.zmq.pojo.Ccc;
import com.zmq.pojo.User;
import com.zmq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService  {

    @Autowired
    private UserDao userDao;


    public List<User> findUsers() {
        return userDao.findUsers();
    }


    public int saveRegister(User user) {
        int i = userDao.saveRegister(user);
        return i;
    }


    public User login(User user) {
        User login = userDao.login(user);
        return login;
    }

    public int saveUser(User entity) {
       entity.setUserName("钟明强");
        return userDao.saveUser(entity);
    }

    public List<Ccc> findCcc() {
        return userDao.findCcc();
    }
}

