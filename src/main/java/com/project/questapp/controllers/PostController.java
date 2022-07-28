package com.project.questapp.controllers;

import com.project.questapp.entities.Post;
import com.project.questapp.requests.PostCreateRequest;
import com.project.questapp.requests.PostUpdateRequest;
import com.project.questapp.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
@CrossOrigin("*")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/list")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    /** PROBLEM!!!
     * This method is used to get all the posts posted by a user that has the unique userId parameter as id.
     * @param userId id of the user that posted the posts.
     * @return list of all posts by the user. If the user with the userId does not exist, or the user did not post anything,
     * it returns all the posts.
     */
    @GetMapping("/list/{userId}")
    public List<Post> getAllPostsByUserId(@PathVariable Optional<Long> userId) {
        return postService.getAllPostsByUserId(userId);
    }

    /**
     * This method gets the post with the given parameter id.
     * @param postId id of the post to be returned
     * @return the post with the id.
     */
    @GetMapping("/{postId}")
    public Optional<Post> getOnePostById(@PathVariable Long postId) {
        return postService.getOnePostById(postId);
    }

    /**
     * Creates a post with the credentials of newPostRequest
     * @param newPostRequest carries credentials of the post
     * @return "Success!" if the post is created successfully, "Failed: Such a post with the same id already exists!" if
     * the post with the same id exists, and "Failed: Such a user does not exist!" if the user does not exist.
     */
    @PostMapping("/create")
    public String createOnePost(@RequestBody PostCreateRequest newPostRequest) {
        return postService.createOnePost(newPostRequest);
    }

    /**
     * This method is used to update one post.
     * @param postId the id of the post to be updated.
     * @param updatePost updated text and title of the post carried here
     * @return "Success!" if it is done, "Failed: No post with this id exists!" if not.
     */
    @PutMapping("/{postId}")
    public String updateOnePostById(@PathVariable Long postId, @RequestBody PostUpdateRequest updatePost) {
        return postService.updateOnePostById(postId, updatePost);
    }

    /**
     * Deleted the post with the given id.
     * @param postId
     * @return "Success!" if it is successfully deleted, "Failed: No such post exists!" if no post exists.
     */
    @DeleteMapping("/{postId}")
    public String deleteOnePostById(@PathVariable Long postId) {
        return postService.deleteById(postId);
    }
}
