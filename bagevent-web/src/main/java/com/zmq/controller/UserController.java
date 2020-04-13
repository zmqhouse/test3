package com.zmq.controller;

import com.zmq.pojo.Ccc;
import com.zmq.pojo.User;
import com.zmq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(User user, Model model) {
        User login = userService.login(user);
        if (login != null) {
            return "success";
        }
        model.addAttribute("msg", "登录失败");
        return "error";

    }


    //注册
    @RequestMapping(value = "saveRegister", method = RequestMethod.POST)
    public String saveRegister(User user, Model model) {
        int i = userService.saveRegister(user);
        if (i > 0) {
            return "login";
        }
        model.addAttribute("msg", "注册失败");
        return "error";

    }

    //跳转登录页面
    @RequestMapping("tologin")
    public String tologin() {
        return "login";
    }

    //跳转注册页面
    @RequestMapping("register")
    public String register() {
        return "register";
    }

    @RequestMapping("/getUsers")
    public String findUsers(Model model) {
        List<User> users = userService.findUsers();
        model.addAttribute("users", users);
        return "user";
    }

    @RequestMapping("/getCcc")
    public String findCcc(Model model) {
        List<Ccc> users = userService.findCcc();
        model.addAttribute("users", users);
        return "user";
    }

    @RequestMapping("/saveUser")
    public String saveUsser() {
        User user = new User();
        userService.saveUser(user);
        return "error";
    }

}
