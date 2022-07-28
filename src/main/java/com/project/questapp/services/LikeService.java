package com.project.questapp.services;

import com.project.questapp.entities.Like;
import com.project.questapp.requests.LikeCreateRequest;

import java.util.List;
import java.util.Optional;

public interface LikeService {

    public List<Like> getAllLikesByPostId(Optional<Long> postId);
    public Optional<Like> getOneLikeById(Long likeId);
    public Like createOneLike(LikeCreateRequest newLike);
    public void deleteOneLike(Long likeId);
}
