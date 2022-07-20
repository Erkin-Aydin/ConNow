package com.project.questapp.controllers;

import com.project.questapp.entities.Post;
import com.project.questapp.requests.PostCreateRequest;
import com.project.questapp.requests.PostUpdateRequest;
import com.project.questapp.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAllPosts(@RequestParam Optional<Long> userId) {
        return postService.getAllPosts(userId);
    }

    @GetMapping("/{postId}")
    public Optional<Post> getOnePostById(@PathVariable Long postId) {
        return postService.getOnePostById(postId);
    }

    @PostMapping
    public Post createOnePost(PostCreateRequest newPostRequest) {
        return postService.createOnePost(newPostRequest);
    }

    @PutMapping("/{postId}")
    public Post updateOnePostById(@PathVariable Long postId, @RequestBody PostUpdateRequest updatePost) {
        return postService.updateOnePostById(postId, updatePost);
    }

    @DeleteMapping("/{postId}")
    public void deleteOnePostById(Long postId) {
        postService.deleteById(postId);
    }
}
