package com.project.questapp.services;

import com.project.questapp.entities.Comment;
import com.project.questapp.requests.CommentCreateRequest;
import com.project.questapp.requests.CommentUpdateRequest;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    /**
     * This method gets all the comments in existence.
     * @return list of all the comments in existence.
     */
    public List<Comment> getAllComments();

    /**
     * This method gets all the comments under the post with parameter postId.
     * @param postId id of the post.
     * @return list of all comments under the post with parameter postId.
     */
    public List<Comment> getAllCommentsByPostId(Optional<Long> postId);

    /**
     * This method gets the comment with parameter commentId.
     * @param commentId id of the comment to be returned.
     * @return the comment with the parameter commentId if it exists, null if not.
     */
    public Optional<Comment> getOneCommentById(Long commentId);

    /**
     * This method creates a comment with credentials of parameter newCommentRequest
     * @param newCommentRequest carries the credentials of the comment to be created
     * @return "Success!" if the comment is created successfully, a fail message with relevant context if not.
     */
    public String createOneComment(CommentCreateRequest newCommentRequest);

    /**
     * This method updates the comment with parameter commentId with credentials of parameter updateRequest.
     * @param commentId id f the comment to be updated.
     * @param updateRequest carries the new credentials of the comment to be updated.
     * @return "Success!" if the comment is updated successfully, a fail message with relevant context if not.
     */
    public String updateOneCommentById(Long commentId, CommentUpdateRequest updateRequest);

    /**
     * This method deleted the comment with parameter commentId.
     * @param commentId id of the comment to be deleted.
     * @return "Success!" if the comment is deleted successfully, a fail message with relevant context if not.
     */
    public String deleteOneCommentById(Long commentId);
}
