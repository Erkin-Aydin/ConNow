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
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    /**
     * Gets all the existing comments in commentRepository.
     * @return all the existing comments in commentRepository. If no comments exist, then return an empty list.
     */
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    /**
     * Gets all the comments commented to the post with the id given through parameter postId. If no such comment exists,
     * returns all the comments in the commentRepository.
     * @param postId the id of the post.
     * @return list of comments under the post. If such post does not exist, null.
     */
    public List<Comment> getAllCommentsByPostId(Optional<Long> postId) {
        Optional<Post> post = postService.getOnePostById(postId.get());
        if(post.isEmpty()) {
            return commentRepository.findAll();
        }
        else {
            return commentRepository.findByPostId(postId.get());
        }
    }
    /**
     * This method returns the comment with the unique commentId parameter.
     * @param commentId id of the comment to be returned.
     * @return the comment if it exists, null if not
     */
    public Optional<Comment> getOneCommentById(Long commentId) {
        //If such a comment is present, then we return it. If not, we return null.
        return commentRepository.findById(commentId);
    }

    /**
     * This method is used to create a comment under a post
     * @param commentCreateRequest carries credentials of the upcoming comment.
     * @return "Success!" if it is created successfully, a fail message with its reason if not.
     */
    public String createOneComment(CommentCreateRequest commentCreateRequest) {
        Optional<User> user = userService.getOneUser(commentCreateRequest.getUserId());
        Optional<Post> post = postService.getOnePostById(commentCreateRequest.getPostId());
        //If the user to comment, or the post to be commented, does not exist, we can't create te comment.
        if(user.isEmpty()) {
            return "Failed: User does not exist!";
        }
        else if(post.isEmpty()) {
            return "Failed: Post does not exist!";
        }
        else if(commentRepository.findById(commentCreateRequest.getId()).isPresent()) {
            return "Failed: A comment with the same id already exists!";
        }
        //If they exist, then we create the comment accordingly.
        else {
            Comment toSave = new Comment();
            toSave.setId(commentCreateRequest.getId());
            toSave.setText(commentCreateRequest.getText());
            toSave.setUser(user.get());
            toSave.setPost(post.get());
            commentRepository.save(toSave);
            return "Success!";
        }
    }

    /**
     * This method is used to update an existing comment.
     * @param commentId id of the comment that will be updated.
     * @param updateRequest new credentials of the comment.
     * @return "Success!" if it is updated, fail message if not.
     */
    public String updateOneCommentById(Long commentId, CommentUpdateRequest updateRequest) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if(comment.isEmpty()) {
            return "Failed: The comment is not present!";
        }
        //If it exists, we update it.
        else {
            Comment toSave = comment.get();//Retrieving the comment.
            toSave.setText(updateRequest.getText());//Changing its text.
            commentRepository.save(toSave);//Saving updated version to
            return "Success!";
        }
    }

    /**
     * This method is used to delete a comment.
     * @param commentId id of the comment to be deleted
     * @return "Success" if successful, "Failed: No such comment exists!" if no comment found with the id.
     */
    public String deleteOneCommentById(Long commentId) {
        if(commentRepository.findById(commentId).isEmpty()) {
            return "Failed: No such comment exists!";
        }
        else {
            commentRepository.deleteById(commentId);
            return "Success";
        }
    }

}
