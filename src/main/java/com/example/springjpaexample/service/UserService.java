package com.example.springjpaexample.service;

import com.example.springjpaexample.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    List<User> getAllUsers();
}
