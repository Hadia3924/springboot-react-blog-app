package com.hadia.blogApp.service;

import com.hadia.blogApp.model.User;
import com.hadia.blogApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCrypt;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user){
        if (user.getPasswordHash() == null || user.getPasswordHash().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null");
        }
        user.setPassword(user.getPasswordHash());
        return userRepository.save(user);
    }

    @Override
    public User loginUser(String username, String password){
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (!BCrypt.checkpw(password, user.getPasswordHash())) {
            throw new RuntimeException("Invalid credentials");
        }
        return user;
    }

    @Override
    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, User user){
        User existingUser = getUserById(id);

        if(userRepository.existsByUsername(user.getUsername()) && !existingUser.getUsername().equals(user.getUsername())){
            throw new RuntimeException("Username already exists");
        }

        if(userRepository.existsByEmail(user.getEmail()) && !existingUser.getEmail().equals(user.getEmail())){
            throw new RuntimeException("Email already exists");
        }

        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        existingUser.setRole(user.getRole());
        if (user.getPasswordHash() != null && !user.getPasswordHash().isEmpty()) {
            existingUser.setPassword(user.getPasswordHash());
        }
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
