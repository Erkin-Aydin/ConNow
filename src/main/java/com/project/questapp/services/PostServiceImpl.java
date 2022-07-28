package com.project.questapp.services;

import com.project.questapp.entities.Post;
import com.project.questapp.entities.User;
import com.project.questapp.repos.PostRepository;
import com.project.questapp.requests.PostCreateRequest;
import com.project.questapp.requests.PostUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserService userService;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    /** PROBLEM!!!
     * This method is used to return the list of posts of the user. If user does not exist, list of all posts.
     * @param userId id of the user.
     * @return List of posts of the user. If user does not exist, list of all posts.
     */
    public List<Post> getAllPostsByUserId(Optional<Long> userId) {
        Optional<User> user = userService.getOneUser(userId.get());
        if(!user.isPresent()) {
            return postRepository.findAll();
        }
        else {
            List<Post> posts = postRepository.findByUserId(userId.get());
            return posts;
        }
    }

    /**
     * This method gets the post with the given parameter id.
     * @param postId id of the post to be returned
     * @return the post with the id. If the post does not exist, returns null.
     */
    public Optional<Post> getOnePostById(Long postId) {
        return postRepository.findById(postId);
    }

    /**
     * Creates a post with the credentials of newPostRequest
     * @param newPostRequest carries credentials of the post
     * @return "Success!" if the post is created successfully, "Failed: Such a post with the same id already exists!" if
     * the post with the same id exists, and "Failed: Such a user does not exist!" if the user does not exist.
     */
    public String createOnePost(PostCreateRequest newPostRequest) {
        //Retrieving whether the user in the request actually exists.
        Optional<User> user = userService.getOneUser(newPostRequest.getUserId());
        Optional<Post> post = postRepository.findById(newPostRequest.getId());
        //If the user does not exist, then is can't post anything.
        if (!user.isPresent()) {
            return "Failed: Such a user does not exist!";
        }
        else if(post.isPresent()) {
            return "Failed: Such a post with the same id already exists!";
        }
        /* If the user exists and such a post with the same postId does not exist, then we create a post, with respect
         * to the post request, then save it to the postRepository.
         */
        else {
            Post toSave = new Post();
            toSave.setId(newPostRequest.getId());
            toSave.setText(newPostRequest.getText());
            toSave.setTitle(newPostRequest.getTitle());
            toSave.setUser(user.get());
            postRepository.save(toSave);
            return "Success!";
        }
    }

    /**
     * This method is used to update one post.
     * @param postId the id of the post to be updated.
     * @param updatePost updated text and title of the post carried here
     * @return "Success!" if it is done, "Failed: No post with this id exists!" if not.
     */
    public String updateOnePostById(Long postId, PostUpdateRequest updatePost) {
        //Retrieving whether the post in the request actually exists.
        Optional<Post> post = postRepository.findById(postId);
        //If the post does not exist, then it can't be modified, obviously.
        if(!post.isPresent()) {
            return "Failed: No post with this id exists!";
        }
        //If it exists, we modify it, and save it to postRepository.
        else {
            Post toUpdate = post.get();
            toUpdate.setText(updatePost.getText());
            toUpdate.setTitle(updatePost.getTitle());
            postRepository.save(toUpdate);
            return "Success!";
        }
    }

    /**
     * Deleted the post with the given id.
     * @param postId
     * @return "Success!" if it is successfully deleted, "Failed: No such post exists!" if no post exists.
     */
    public String deleteById(Long postId) {
        if(!postRepository.findById(postId).isPresent()) {
            return "Failed: No such post exists!";
        }
        else {
            postRepository.deleteById(postId);
            return "Success!";
        }
    }
}
