package com.example.demo.service;

import com.example.demo.model.Login;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public String Login(Login user);
    public String Logout(Login user);
    public String changePassword(Login obj, String userId);
    public List<Login> fetchAll();
}
