package com.project.questapp.services;

import com.project.questapp.entities.Post;
import com.project.questapp.requests.PostCreateRequest;
import com.project.questapp.requests.PostUpdateRequest;

import java.util.List;
import java.util.Optional;

public interface PostService {
    public List<Post> getAllPostsByUserId(Optional<Long> userId);
    public Optional<Post> getOnePostById(Long postId);
    public String createOnePost(PostCreateRequest newPostRequest);
    public String updateOnePostById(Long postId, PostUpdateRequest updatePost);
    public String deleteById(Long postId);
    public List<Post> getAllPosts();
}
