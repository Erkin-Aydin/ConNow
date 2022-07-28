package com.project.questapp.controllers;

import com.project.questapp.entities.Comment;
import com.project.questapp.requests.CommentCreateRequest;
import com.project.questapp.requests.CommentUpdateRequest;
import com.project.questapp.services.CommentService;
import com.project.questapp.services.PostService;
import com.project.questapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    /**
     *
     * @return
     */
    @GetMapping("/list")
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    /**
     *
     * @param postId
     * @return
     */
    @GetMapping("/commentList/{postId}")
    public List<Comment> getAllCommentsByPostId(@PathVariable Optional<Long> postId) {
        return commentService.getAllCommentsByPostId(postId);
    }


    /**
     *  Returns the comment with the @PathVariable parameter commentId. If such a comment does not exist, it returns null.
     * @param commentId id of the comment
     * @return comment by id.
     */
    @GetMapping("/{commentId}")
    public Optional<Comment> getOneCommentById(@PathVariable Long commentId) {

        return commentService.getOneCommentById(commentId);
    }

    /**
     * This method is used to create a comment under a post
     * @param commentCreateRequest carries credentials of the upcoming comment.
     * @return "Success!" if it is created successfully, a fail message with its reason if not.
     */
    @PostMapping("/create")
    public String createOneComment(@RequestBody CommentCreateRequest commentCreateRequest) {
        return commentService.createOneComment(commentCreateRequest);
    }

    /**
     * This method is used to update an existing comment.
     * @param commentId id of the comment that will be updated.
     * @param updateRequest new credentials of the comment.
     * @return "Success!" if it is updated, fail message if not.
     */
    @PutMapping("/update/{commentId}")
    public String updateOneCommentById(@PathVariable Long commentId, @RequestBody CommentUpdateRequest updateRequest) {
        return commentService.updateOneCommentById(commentId, updateRequest);
    }

    /**
     * This method is used to delete a comment.
     * @param commentId id of the comment to be deleted
     */
    @DeleteMapping("/delete/{commentId}")
    public String deleteOneCommentById(@PathVariable Long commentId) {
        return commentService.deleteOneCommentById(commentId);
    }
}
