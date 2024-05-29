package com.example.spring_boot_jpa.service;

import com.example.spring_boot_jpa.entity.UserEntity;
import com.example.spring_boot_jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }
}//class
