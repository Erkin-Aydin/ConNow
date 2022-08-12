package com.project.questapp.controllers;

import com.project.questapp.common.ApiResponse;
import com.project.questapp.entities.User;
import com.project.questapp.requests.UserCheckPasswordRequest;
import com.project.questapp.requests.UserCreateRequest;
import com.project.questapp.requests.UserPasswordUpdateRequest;
import com.project.questapp.requests.UserUpdateRequest;
import com.project.questapp.responses.UserResponse;
import com.project.questapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * This method returns the list of users in the userRepository
     * @return List of users in the repository.
     */
    @GetMapping("/list")
    public UserResponse[] getAllUsers() {
        //return userService.getAllUsers();
       List<User> users = userService.getAllUsers();
       UserResponse[] userResponses = new UserResponse[users.size()];
       for(int i = 0; i < users.size(); i++) {
           UserResponse newUserResponse = new UserResponse();
           newUserResponse.setUserName(users.get(i).getUsername());
           userResponses[i] = newUserResponse;
       }
       return userResponses;
    }

    /**
     * This method will create a user with the given user information through createRequest. It returns "Success!" if such
     * a user with incoming createRequest.getId() does not exist in te system and creates a user with these credentials.
     * Returns "Failed: User with the given id already exists." otherwise.
     *
     * @param createRequest is the user information of the incoming user
     * @return newUser
     */
    @PostMapping("/create")
    public ResponseEntity createUser(@RequestBody UserCreateRequest createRequest) {

        try {
            userService.createUser(createRequest);

            ApiResponse apiResponse = new ApiResponse("Success!", true);
            return new ResponseEntity(apiResponse,HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse apiResponse = new ApiResponse("Failed!", false);
            return new ResponseEntity(apiResponse,HttpStatus.CONFLICT);
        }
    }

    /**
     * This function is used to get the user with the parameter userId.
     * @param userId as the id of the user to be returned.
     * @return the user with the unique userId given in the parameter, null if such user does not exist.
     */
    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable Long userId) {
        //custom exception
        return userService.getOneUser(userId).orElse(null);
    }

    @GetMapping("getThroughMail/{email}")
    public Optional<User> getOneUserThroughEmail(@PathVariable String email) {
        return userService.getOneUserThroughEmail(email);
    }

    /**
     * Checks whether a user exists through its email
     * @param email email of the user to be found
     * @return true if the user exists, false if not.
     */
    @GetMapping("/email/{email}")
    public boolean doesUserExist(@PathVariable String email) {
        return userService.doesUserExist(email);
    }

    /**
     * This method updates the user with the parameter userId with the parameter updateRequest. Returns the
     * @param email is taken as a PathVariable, the email of the user to be updated.
     * @param updateRequest as the new credentials of the user(id can't be updated!!!)
     * @return "Success!" if successful, a fail message if not.
     */
    @PutMapping("/{email}")
    public String updateOneUser(@PathVariable String email, @RequestBody UserUpdateRequest updateRequest) {
        return userService.updateOneUser(email, updateRequest);
    }

    /**
     *
     * @param request
     * @return
     */
    @GetMapping("/checkPassword")
    public boolean checkPassword(@RequestBody UserCheckPasswordRequest request) {
        return userService.getOneUserThroughEmail(request.getEmail()).get().getPassword().equals(request.getPassword());
    }

    @PutMapping("/passwordChange")
    public boolean updatePassword(@RequestBody UserPasswordUpdateRequest passwordUpdateRequest) {
        String email = passwordUpdateRequest.getEmail();
        String password = passwordUpdateRequest.getPassword();
        userService.updatePassword(passwordUpdateRequest);
        Optional<User> user = getOneUserThroughEmail(email);
        return user.get().getPassword().equals(password);
    }

    /**
     * This method is used to delete a user.
     * @param userId the id of the user to be deleted
     * @return "Success!" if the user exists and thus deleted from the userRepository, "Failed: User with the given id
     * does not exist!" is such user does not exist, "Failed: User does exist, but for some reason it can't be deleted!"
     * if the user exists but can't be deleted.
     */
    @DeleteMapping("/{userId}")
    public String deleteOneUser(@PathVariable Long userId) {
        return userService.deleteById(userId);
    }
}
