package com.aadit.notepad_backend.controller;

import com.aadit.notepad_backend.model.User;
import com.aadit.notepad_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class userController {

    @Autowired
    private UserService userService;

    //Register a new user
    @PostMapping("/register")
    public String RegisterUser(@RequestParam String username,@RequestParam String password){
        try{
            User createUser= userService.createUser(username,password);
            return "User registered: " +createUser.getUsername();
        }catch (RuntimeException e){
            return "Error"+e.getMessage();
        }
    }

    // Login user
    @PostMapping("/login")
    public String loginUser(@RequestParam String username ,@RequestParam String password){
        boolean success=userService.loginUser(username,password);
        return success?"Login successful":"invalid credential";
    }

}
