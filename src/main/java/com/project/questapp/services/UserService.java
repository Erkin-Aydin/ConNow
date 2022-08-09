package com.project.questapp.services;

import com.project.questapp.entities.User;
import com.project.questapp.requests.UserCreateRequest;
import com.project.questapp.requests.UserUpdateRequest;
import com.project.questapp.responses.UserResponse;

import java.util.List;
import java.util.Optional;

public interface UserService {

    /**
     * This method is to get all users.
     * @return list of all users
     */
    List<User> getAllUsers();

    /**
     * This method creates a user using the credentials of parameter createRequest
     * @param createRequest carries the credentials of new user.
     */
    void createUser(UserCreateRequest createRequest) throws Exception;

    /**
     * This method gets one user using the parameter userId
     * @param userId id of the user to be returned.
     * @return user if it exists, null if not.
     */
    Optional<User> getOneUser(Long userId);

    /**
     * This method updated the credentials of a user if such a user with userId exists.
     * @param userId id of the user to be updated.
     * @param updateRequest carries new credentials of the user
     * @return "Success!" if the user is updated successfully, a fail message with relevant context if not.
     */
    String updateOneUser(Long userId, UserUpdateRequest updateRequest);

    /**
     * This method deleted the user with parameter userId.
     * @param userId the id of the user to be deleted
     * @return "Success!" if the user is deleted successfully, a fail message with relevant context if not.
     */
    String deleteById(Long userId);
}
