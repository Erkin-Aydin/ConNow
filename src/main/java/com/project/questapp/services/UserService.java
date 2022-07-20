package com.project.questapp.services;

import com.project.questapp.entities.User;
import com.project.questapp.repos.UserRepository;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.util.List;
import java.util.Optional;
@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User save(User newUser) {
        return userRepository.save(newUser);
    }

    public Optional<User> getOneUser(Long userId) {
        return userRepository.findById(userId);
    }

    public User updateOneUser(Long userId, User newUser) {
        Optional<User> user = userRepository.findById(userId);
        if(!user.isPresent()) {
            return null;
        }
        else {
            User foundUser = user.get();
            foundUser.setUserName(newUser.getUserName());
            foundUser.setPassword(newUser.getPassword());
            userRepository.save(foundUser);
            return foundUser;
        }
    }

    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }
}
