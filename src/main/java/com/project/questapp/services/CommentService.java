package com.project.questapp.services;

import com.project.questapp.entities.Comment;
import com.project.questapp.requests.CommentCreateRequest;
import com.project.questapp.requests.CommentUpdateRequest;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    public List<Comment> getAllComments();
    public List<Comment> getAllCommentsByPostId(Optional<Long> postId);
    public Optional<Comment> getOneCommentById(Long commentId);
    public String createOneComment(CommentCreateRequest newCommentRequest);
    public String updateOneCommentById(Long commentId, CommentUpdateRequest updateRequest);
    public String deleteOneCommentById(Long commentId);
}
