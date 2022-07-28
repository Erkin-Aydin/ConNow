package com.project.questapp.services;

import com.project.questapp.entities.Post;
import com.project.questapp.requests.PostCreateRequest;
import com.project.questapp.requests.PostUpdateRequest;

import java.util.List;
import java.util.Optional;

public interface PostService {

    /**
     *
     * @param userId
     * @return
     */
    public List<Post> getAllPostsByUserId(Optional<Long> userId);

    /**
     *
     * @param postId
     * @return
     */
    public Optional<Post> getOnePostById(Long postId);

    /**
     *
     * @param newPostRequest
     * @return
     */
    public String createOnePost(PostCreateRequest newPostRequest);

    /**
     *
     * @param postId
     * @param updatePost
     * @return
     */
    public String updateOnePostById(Long postId, PostUpdateRequest updatePost);

    /**
     *
     * @param postId
     * @return
     */
    public String deleteById(Long postId);

    /**
     *
     * @return
     */
    public List<Post> getAllPosts();
}
