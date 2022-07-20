package com.project.questapp.services;

import com.project.questapp.entities.Comment;
import com.project.questapp.entities.Post;
import com.project.questapp.entities.User;
import com.project.questapp.repos.CommentRepository;
import com.project.questapp.requests.CommentCreateRequest;
import com.project.questapp.requests.CommentUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    public List<Comment> getAllCommentsByPostId(Optional<Long> postId) {
        if(!postId.isPresent()) {
            return commentRepository.findAll();
        }
        else {
           // return commentRepository.findByPostId(postId.get());
            return null;
        }
    }
    public List<Comment> getAllCommentsByUserId(Optional<Long> userId) {
        //If such user is present, then return all of its comments. If not, return null.
        if(!userId.isPresent()) {
            return null;
        }
        else {
           // return commentRepository.findByUserId(userId.get());
            return null;
        }
    }

    public Comment getOneCommentById(Long commentId) {
        //If such a comment is present, then we return it. If not, we return null.
        return commentRepository.findById(commentId).orElse(null);
    }

    public Comment createOneComment(CommentCreateRequest newCommentRequest) {
        Optional<User> user = userService.getOneUser(newCommentRequest.getUserId());
        Optional<Post> post = postService.getOnePostById(newCommentRequest.getPostId());
        //If the user to comment, or the post to be commented, does not exist, we can't create te comment.
        if(!user.isPresent() || !post.isPresent()) {
            return null;
        }
        //If they exist, then we create the comment accordingly.
        else {
            Comment toSave = new Comment();
            toSave.setId(newCommentRequest.getId());
            toSave.setText(newCommentRequest.getText());
            toSave.setUser(user.get());
            toSave.setPost(post.get());
            return commentRepository.save(toSave);
        }
    }

    public Comment updateOneCommentById(Long commentId, CommentUpdateRequest updateRequest) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        //If the comment to be updated does not exist, we can't update it.
        if(!comment.isPresent()) {
            return null;
        }
        //If it exists, we update it.
        else {
            Comment toSave = comment.get();//Retrieving the comment.
            toSave.setText(updateRequest.getText());//Changing its text.
            commentRepository.save(toSave);//Saving updated version to
            return toSave;
        }
    }

    public void deleteOneCommentById(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
