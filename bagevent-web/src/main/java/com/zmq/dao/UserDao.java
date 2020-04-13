package com.zmq.dao;

import com.zmq.pojo.Ccc;
import com.zmq.pojo.User;

import java.util.List;

public interface UserDao {

    User login(User user);

    int saveRegister(User user);


    List<User> findUsers();

    int saveUser(User entity);

    List<Ccc> findCcc();

}
