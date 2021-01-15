package com.socialfeedapi.service;

import com.socialfeedapi.entity.Post;
import com.socialfeedapi.entity.User;
import com.socialfeedapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User saveUser(User user) {
        return repository.save(user);
    }

    public List<User> getUsers() {
        return repository.findAll();
    }

    public User getUserById(int id) {
        return repository.findById(id).orElse(null);
    }

    public User getUserByUsername(String username) {
        return repository.findByUsername(username);
    }

    public void deleteUser(int id){
        repository.deleteById(id);
    }

    public User updateUser(User user){
        User existingUser=repository.findById(user.getId()).orElse(null);
        existingUser.setFirstname(user.getFirstname());
        existingUser.setLastname(user.getLastname());
        existingUser.setUsername(user.getUsername());
        return repository.save(existingUser);
    }
}