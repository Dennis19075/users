package com.example.users.services;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.users.models.UserModel;
import com.example.users.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ArrayList<UserModel> findAllUsers(){
        return (ArrayList<UserModel>)userRepository.findAll();
    }

    public UserModel saveUser(UserModel user){
        return userRepository.save(user);
    }

    public Optional<UserModel> getUserById(Long userId){
        return userRepository.findById(userId);
    }

    public ArrayList<UserModel> getUserByPriority(String priority){
        return userRepository.findByPriority(priority);
    }

    public boolean deleteUser(Long userId){
        try {
            userRepository.deleteById(userId);
            return true;
        } catch (Exception rr) {
            return false;
        }
    }


}
