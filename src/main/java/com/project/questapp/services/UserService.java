package com.project.questapp.services;

import com.project.questapp.entities.User;
import com.project.questapp.requests.UserCreateRequest;
import com.project.questapp.requests.UserUpdateRequest;

import java.util.List;
import java.util.Optional;

public interface UserService {

    /**
     *
     * @return
     */
    List<User> getAllUsers();

    /**
     *
     * @param createRequest
     * @return
     */
    String createUser(UserCreateRequest createRequest);

    /**
     *
     * @param userId
     * @return
     */
    Optional<User> getOneUser(Long userId);

    /**
     *
     * @param userId
     * @param updateRequest
     * @return
     */
    String updateOneUser(Long userId, UserUpdateRequest updateRequest);

    /**
     *
     * @param userId
     * @return
     */
    String deleteById(Long userId);
}
