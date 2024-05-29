package com.example.spring_boot_jpa.controller;

import com.example.spring_boot_jpa.entity.UserEntity;
import com.example.spring_boot_jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    // GET localhost:8080/user
    @GetMapping("")
    public List<UserEntity> getUsers(){ //method명 getUsers
        return userService.getUsers();
    }

}//class
