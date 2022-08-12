package com.project.questapp.controllers;

import com.project.questapp.entities.Comment;
import com.project.questapp.requests.CommentCreateRequest;
import com.project.questapp.requests.CommentUpdateRequest;
import com.project.questapp.responses.CommentResponse;
import com.project.questapp.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    /**
     * This method gets all the comments.
     * @return list of all comments.
     */
    @GetMapping("/list")
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    /**
     * This method gets all the comments under the post with parameter postId.
     * @param postId id of the post.
     * @return list of all comments under the post with the parameter postId.
     */
    @GetMapping("/commentList/{postId}")
    public List<CommentResponse> getAllCommentsByPostId(@PathVariable Long postId) {
        List<Comment> commentList = commentService.getAllCommentsByPostId(postId);

        List<CommentResponse> commentResponseList = new ArrayList<>();
        for(Comment comment : commentList) {
            CommentResponse responseToSave = new CommentResponse();
            //Setting userName.
            responseToSave.setUserName(comment.getUser().getUsername());
            //Setting title.
            responseToSave.setText(comment.getText());
            commentResponseList.add(responseToSave);
        }

        return commentResponseList;
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
