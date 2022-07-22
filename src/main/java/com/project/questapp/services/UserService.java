package com.project.questapp.services;

import com.project.questapp.entities.User;
import com.project.questapp.requests.UserCreateRequest;
import com.project.questapp.requests.UserUpdateRequest;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    String createUser(UserCreateRequest createRequest);
    Optional<User> getOneUser(Long userId);
    String updateOneUser(Long userId, UserUpdateRequest updateRequest);
    String deleteById(Long userId);
}
