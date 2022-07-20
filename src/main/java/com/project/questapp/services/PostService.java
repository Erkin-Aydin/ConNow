package com.project.questapp.services;

import com.project.questapp.entities.Post;
import com.project.questapp.entities.User;
import com.project.questapp.repos.PostRepository;
import com.project.questapp.requests.PostCreateRequest;
import com.project.questapp.requests.PostUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private PostRepository postRepository;
    private UserService userService;

    //Constructor for PostService
    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }
    //If the userId is present, it returns all posts of the user. If not, it returns all the posts.
    public List<Post> getAllPosts(Optional<Long> userId) {
        if(!userId.isPresent()) {
            return postRepository.findAll();
        }
        else {
            //return postRepository.findBy
            return postRepository.findByUserId(userId.get());
        }
    }

    //If a post with the parameter id exists, it returns it. If not, returns null.
    public Optional<Post> getOnePostById(Long postId) {
        return postRepository.findById(postId);
    }

    //It creates a post for the user, if possible. If it is ot possible, returns null.
    public Post createOnePost(PostCreateRequest newPostRequest) {
        //Retrieving whether the user in the request actually exists.
        Optional<User> user = userService.getOneUser(newPostRequest.getUserId());
        //If the user does not exist, then is can't post anything.
        if (!user.isPresent()) {
            return null;
        }
        //If the user exists, then ve create a post, with respect to the post request, then save it to the postRepository.
        else {
            Post toSave = new Post();
            toSave.setId(newPostRequest.getId());
            toSave.setText(newPostRequest.getText());
            toSave.setTitle(newPostRequest.getTitle());
            toSave.setUser(user.get());
            return postRepository.save(toSave);
        }
    }

    //This method is used to update an already existing post.
    public Post updateOnePostById(Long postId, PostUpdateRequest updatePost) {
        //Retrieving whether the post in the request actually exists.
        Optional<Post> post = postRepository.findById(postId);
        //If the post does not exist, then it can't be modified, obviously.
        if(!post.isPresent()) {
            return null;
        }
        //If it exists, we modify it, and save it to postRepository.
        else {
            Post toUpdate = post.get();
            toUpdate.setText(updatePost.getText());
            toUpdate.setTitle(updatePost.getTitle());
            postRepository.save(toUpdate);
            return toUpdate;
        }
    }

    //Deletes a post with its id.
    public void deleteById(Long postId) {
        postRepository.deleteById(postId);
    }
}
