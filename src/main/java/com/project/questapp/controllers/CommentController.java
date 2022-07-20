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

    @GetMapping("/commentList")
    public List<Comment> getAllCommentsByPostId(@RequestParam Optional<Long> postId) {
        return commentService.getAllCommentsByPostId(postId);
    }

    @GetMapping("/{commentId}")
    public Comment getOneCommentById(@PathVariable Long commentId) {

        return commentService.getOneCommentById(commentId);
    }

    @PostMapping("create")
    public Comment createOneComment(@RequestBody CommentCreateRequest commentCreateRequest) {
        return commentService.createOneComment(commentCreateRequest);
    }

    @PutMapping("update/{commentId}")
    public Comment updateOneCommentById(@PathVariable Long commentId, @RequestBody CommentUpdateRequest updateRequest) {
        return commentService.updateOneCommentById(commentId, updateRequest);
    }

    @DeleteMapping("delete/{commentId}")
    public void deleteOneCommentById(@PathVariable Long commentId) {
        commentService.deleteOneCommentById(commentId);
    }
}
