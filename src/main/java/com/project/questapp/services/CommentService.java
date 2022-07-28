package com.project.questapp.services;

import com.project.questapp.entities.Comment;
import com.project.questapp.requests.CommentCreateRequest;
import com.project.questapp.requests.CommentUpdateRequest;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    /**
     *
     * @return
     */
    public List<Comment> getAllComments();

    /**
     *
     * @param postId
     * @return
     */
    public List<Comment> getAllCommentsByPostId(Optional<Long> postId);

    /**
     *
     * @param commentId
     * @return
     */
    public Optional<Comment> getOneCommentById(Long commentId);

    /**
     *
     * @param newCommentRequest
     * @return
     */
    public String createOneComment(CommentCreateRequest newCommentRequest);

    /**
     *
     * @param commentId
     * @param updateRequest
     * @return
     */
    public String updateOneCommentById(Long commentId, CommentUpdateRequest updateRequest);

    /**
     *
     * @param commentId
     * @return
     */
    public String deleteOneCommentById(Long commentId);
}
