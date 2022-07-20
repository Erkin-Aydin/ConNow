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

@RestController
@RequestMapping("comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/getAllComments")
    public List<Comment> getAllCommentsByPostId(@RequestParam Optional<Long> postId) {
        return null;
                //commentService.getAllCommentsByPostId(postId);
    }

    @GetMapping("findCommentsByUserId")
    public List<Comment> getAllCommentsByUserId(@RequestParam Optional<Long> userId) {
        return null;
                //commentService.getAllCommentsByUserId(userId);
    }

    @GetMapping("getOnePost")
    public Comment getOnePostById(@PathVariable Long commentId) {

        return null;
                //commentService.getOneCommentById(commentId);
    }

    @PostMapping("createComment")
    public Comment createOneComment(CommentCreateRequest commentCreateRequest) {
        return commentService.createOneComment(commentCreateRequest);
    }

    @PutMapping("updateComment/{commentId}")
    public Comment updateOneCommentById(@PathVariable Long commentId, @RequestBody CommentUpdateRequest updateRequest) {
        return commentService.updateOneCommentById(commentId, updateRequest);
    }

    @DeleteMapping("deleteComment/{commentId}")
    public void deleteOneCommentById(Long commentId) {
        commentService.deleteOneCommentById(commentId);
    }
}
