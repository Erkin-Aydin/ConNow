package com.project.questapp.services;

import com.project.questapp.entities.Like;
import com.project.questapp.requests.LikeCreateRequest;

import java.util.List;
import java.util.Optional;

public interface LikeService {

    /**
     * This method is used to get all the likes under a post.
     * @param postId the id of the post.
     * @return the list of the posts under a post.
     */
    public List<Like> getAllLikesByPostId(Optional<Long> postId);

    /**
     * This method gets one like by its id.
     * @param likeId id of the like to be returned.
     * @return the like, if it exists. If it doesn't, then null
     */
    public Optional<Like> getOneLikeById(Long likeId);

    /**
     * This method creates a like under a post with respect to parameter LikeCreateRequest.
     * @param newLike carries the credentials of the like to be created.
     * @return "Success!" if like is created successfully, a fail message with relevant context if not.
     */
    public String createOneLike(LikeCreateRequest newLike);

    /**
     * Deletes a like by its id.
     * @param likeId id of the like to be deleted
     * @return "Success!" if like is deleted successfully, a fail message with relevant context if not.
     */
    public String deleteOneLike(Long likeId);
}
