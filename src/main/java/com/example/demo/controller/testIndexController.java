package com.example.demo.controller;

import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class testIndexController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String findIndex(){
        Users user = new Users();
        user.setName("郭迪");
        user.setPhone("131223");
        userRepository.save(user);
        return "login";
    }
}
