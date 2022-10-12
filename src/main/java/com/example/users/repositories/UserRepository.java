package com.example.users.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.users.models.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
     public abstract ArrayList<UserModel> findByPriority(String priority);
}
