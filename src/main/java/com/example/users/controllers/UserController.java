package com.example.users.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.users.models.UserModel;
import com.example.users.services.UserService;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    public ArrayList<UserModel> getUsers(){
        return userService.findAllUsers();
    }

    @PostMapping()
    public UserModel postUser(@RequestBody UserModel user){
        return this.userService.saveUser(user);
    }

    @GetMapping( path = "/{userId}" )
    public Optional<UserModel> getUserById(@PathVariable("userId") Long userId){
        return this.userService.getUserById(userId);
    }

    @GetMapping("/query")
    public ArrayList<UserModel> getUserByPriority(@RequestParam("priority") String priority){
        return this.userService.getUserByPriority(priority);
    }

    @DeleteMapping( path = "/{userId}" )
    public String deleteUserById(@PathVariable("userId") Long userId){
        boolean ok = this.userService.deleteUser(userId);
        if (ok) {
            return "User deleted successfully: " + userId;
        } else {
            return "Could not delete the user selected: " + userId;
        }
    }


}
