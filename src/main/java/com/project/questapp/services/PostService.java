package com.project.questapp.services;

import com.project.questapp.entities.Post;
import com.project.questapp.entities.User;
import com.project.questapp.requests.PostCreateRequest;
import com.project.questapp.requests.PostUpdateRequest;
import com.project.questapp.requests.UserGetRequest;

import java.util.List;
import java.util.Optional;

public interface PostService {

    /**
     * This method gets all the posts of a user with parameter userId.
     * @param userId id of the user.
     * @return list of all the posts posted by the user with parameter userId if such a user exists, all the posts in
     * existence if not.
     */
    List<Post> getAllPostsByUserId(Optional<Long> userId);

    /**
     * This method gets the post with parameter postId.
     * @param postId id of the post to be returned.
     * @return post if such a post with parameter postId exists, null if not.
     */
    Optional<Post> getOnePostById(Long postId);

    /**
     * This method creates a post with parameter newPostRequest credentials.
     * @param newPostRequest carries the credentials of the new post.
     * @return "Success!" if the post is created successfully, a fail message with relevant context if not.
     */
    String createOnePost(PostCreateRequest newPostRequest);

    /**
     * This method updates the post with the parameter postId using the credentials in updatePost.
     * @param postId id of the post to be updated
     * @param updatePost carries the new credentials of the post to be updated.
     * @return "Success!" if the post is updated successfully, a fail message with relevant context if not.
     */
    String updateOnePostById(Long postId, PostUpdateRequest updatePost);

    /**
     * This method deleted a post with parameter postId.
     * @param postId id of the post to be deleted.
     * @return "Success!" if the post is deleted successfully, a fail message with relevant context if not.
     */
    String deleteById(Long postId);

    /**
     * This method gets all the posts in existence.
     * @return list of all posts in existence.
     */
    List<Post> getAllPosts();

    Optional<User> getUserByPost(UserGetRequest postId);
}
