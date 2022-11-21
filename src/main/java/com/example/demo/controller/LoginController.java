package com.example.demo.controller;
import com.example.demo.model.Developer;
import com.example.demo.model.Login;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class LoginController {
    @Autowired
    UserService userservice;

    @GetMapping("/test")
    public String test() {
        return "Working!!!!!";
    }

    /*@PostMapping("/userLogin")
    public String login(@RequestParam String username, @RequestParam String password) {

        try {
            List<Login> list = userservice.findAll();
            boolean flag = false;
            flag = true;
            for (Login l : list) {
                if (l.getPassword().equals(password) && l.getUserId().equals(username)) {
                    return "Login Success";
                }
            }

        } catch (Exception e) {
            return "user Not found";
        }


        return "";
    }*/
    @Autowired
    UserService cred;

    @GetMapping("/allUsers")
    public List<Login> getAllDevelopers() {
        return userservice.fetchAll();
    }

    @PostMapping(value="/login")
    public String loginUser(@RequestBody Login user) {

        cred.Login(user);
        return"Login successfully";
    }


    @PostMapping("logout")
    public String logUserOut(@RequestBody Login login) {
        cred.Logout(login);

        return "logout successfully";
    }

    @PutMapping(path="/changePassword/{id}")
    public ResponseEntity<Login> update(@RequestBody Login obj){
        userservice.changePassword(obj, obj.getUserId());
        return new ResponseEntity<Login>(obj, HttpStatus.OK);
    }
    /*public String ChangePassword(@PathVariable("id") String id,@RequestBody Login login) {
        cred.changePassword(id, login);

        return "Updated successfully";
    }*/
}