package com.project.questapp.services;

import com.project.questapp.entities.Like;
import com.project.questapp.requests.LikeCreateRequest;

import java.util.List;
import java.util.Optional;

public interface LikeService {

    /**
     *
     * @param postId
     * @return
     */
    public List<Like> getAllLikesByPostId(Optional<Long> postId);

    /**
     *
     * @param likeId
     * @return
     */
    public Optional<Like> getOneLikeById(Long likeId);
    public String createOneLike(LikeCreateRequest newLike);
    public String deleteOneLike(Long likeId);
}
