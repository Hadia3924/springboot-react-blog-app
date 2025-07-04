package com.hadia.blogApp.service;

import com.hadia.blogApp.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User loginUser(String username, String password);
    User getUserById(Long id);
    List<User> getAllUsers();
    User updateUser(Long id, User user);
    void deleteUser(Long id);
}