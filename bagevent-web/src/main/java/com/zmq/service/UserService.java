package com.zmq.service;

import com.zmq.pojo.Ccc;
import com.zmq.pojo.User;

import java.util.List;

public interface UserService {

    int saveRegister(User user);

    User login(User user);


    List<User> findUsers();

    int saveUser(User entity);
    List<Ccc> findCcc();
}
