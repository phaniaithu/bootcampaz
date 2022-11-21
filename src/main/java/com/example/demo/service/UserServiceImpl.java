package com.example.demo.service;

import com.example.demo.model.Login;

import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userrepository;



    @Override
    public String Login(Login user) {
        List<Login> users = userrepository.findAll();
        for (Login cb : users) {
            if (cb.getUserId().equals(user.getUserId()) && cb.getPassword().equals(user.getPassword()) && cb.getRole().equals(user.getRole()))
            {
	        	if(cb.getLoginStatus()==0)
	        	{
	        		cb.setLoginStatus(1);
	        	}
                userrepository.save(cb);
                return "Login successfully";
            }
        }
        return "Username or password or role is incorrect";

    }
    @Override
    public String Logout(Login user) {
        List<Login> users = userrepository.findAll();
        for (Login cb : users) {
            if (cb.getUserId().equals(user.getUserId()) && cb.getPassword().equals(user.getPassword()) && cb.getRole().equals(user.getRole()))
            {
		        	if(cb.getLoginStatus()==1)
		        	{
		        		cb.setLoginStatus(0);
		        	}
                userrepository.save(cb);
                return "Logout_Successfully";
            }
        }
        return "Error logging out!!";
    }

    @Override
    public String changePassword(Login obj, String userId) {
        List<Login> users = userrepository.findAll();
        for (Login cb : users) {
            if (cb.getUserId().equals(obj.getUserId()))
            {
                cb.setPassword(obj.getPassword());
                userrepository.save(cb);
            }

            return "Updated_successfully";
        }

        return "Error updating the password!!";
    }

    @Override
    public List<Login> fetchAll() {
        return userrepository.findAll();
    }
}
