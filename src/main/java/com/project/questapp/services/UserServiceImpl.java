package com.project.questapp.services;

import com.project.questapp.entities.User;
import com.project.questapp.repos.UserRepository;
import com.project.questapp.requests.UserCreateRequest;
import com.project.questapp.requests.UserPasswordUpdateRequest;
import com.project.questapp.requests.UserUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    /**
     * This function is to return all the users in a List format.
     * @return List of all users
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * This method is used to save a new user to the userRepository. It returns "Success" if such
     * a user with incoming createRequest.getId() does not exist in te system and creates a user with these credentials.
     * Returns "Failed: User with the given id already exists." otherwise.
     * @param createRequest as the informations of the incoming user.
     */
    public void createUser(UserCreateRequest createRequest) throws Exception {
        Optional<User> user = userRepository.findByEmail(createRequest.getEmail());
        //If user with the id exists, then we can't create...
        if(user.isPresent()) {
            throw new Exception("conflict");
        }
        //if it does not exist, we create is, save it, and return "Success".
        else {
            User toSave = new User();
            toSave.setEmail(createRequest.getEmail());
            toSave.setUsername(createRequest.getUserName());
            toSave.setPassword(createRequest.getPassword());
            userRepository.save(toSave);
        }
    }

    /**
     * This function is used to get the user with the parameter userId.
     * @param userId as the id of the user to be returned.
     * @return the user with the unique userId given in the parameter, null if such user does not exist.
     */
    public Optional<User> getOneUser(Long userId) {
        return userRepository.findById(userId);
    }

    public Optional<User> getOneUserThroughEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean doesUserExist(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    /**
     * This method is to update the credentials of a user with the parameter userId.
     * @param email as the id of the user to be updated.
     * @param updateRequest as the new user info that will replace the current one with the given userId.
     * @return "Failed: User with the given id does not exist!" if no user is present with the parameter userId,
     * "Success!" if the user is found with the parameter userId.
     */
    public String updateOneUser(String email, UserUpdateRequest updateRequest) {
        //Finding the user in the userRepository with the given userId
        Optional<User> user = userRepository.findByEmail(email);
        //If the user with the giver userId is not present, then we can't update is as it does not exist.
        if(user.isEmpty()) {
            return "Failed: User with the given id does not exist!";
        }
        //If the user is present, we update it, save it to the repository and return it.
        else {
            User foundUser = user.get();
            foundUser.setEmail(updateRequest.getEmail());
            foundUser.setUsername(updateRequest.getUserName());
            foundUser.setPassword(updateRequest.getPassword());
            userRepository.save(foundUser);
            return "Success!";
        }
    }

    public void updatePassword(UserPasswordUpdateRequest passwordUpdateRequest) {
        Optional<User> user = userRepository.findByEmail(passwordUpdateRequest.getEmail());
        if(user.isPresent()) {
            User foundUser = user.get();
            foundUser.setPassword(passwordUpdateRequest.getPassword());
            userRepository.save(foundUser);
        }
    }

    /**
     * This function is used to delete the user with the parameter userId from userRepository. Returns "Success!" if the
     * user exists and thus deleted from the userRepository, "Failed: User with the given id does not exist!" is such user
     * does not exist. It returns "Failed: User does exist, but for some reason it can't be deleted!"
     * @param userId the id of the user to be deleted.
     * @return "Success!" if the user exists and thus deleted from the userRepository, "Failed: User with the given id
     * does not exist!" is such user does not exist, "Failed: User does exist, but for some reason it can't be deleted!"
     * if the user exists but can't be deleted.
     */
    public String deleteById(Long userId) {
        if(userRepository.findById(userId).isEmpty()) {
            return "Failed: User with the given id does not exist!";
        }
        userRepository.deleteById(userId);
        if(userRepository.findById(userId).isPresent()) {
            return "Failed: User does exist, but for some reason it can't be deleted!";
        }
        else {
            return "Success!";
        }
    }

}
