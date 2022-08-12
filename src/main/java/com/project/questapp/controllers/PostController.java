package com.project.questapp.controllers;

import com.project.questapp.entities.Post;
import com.project.questapp.requests.PostCreateRequest;
import com.project.questapp.requests.PostUpdateRequest;
import com.project.questapp.requests.UserGetRequest;
import com.project.questapp.responses.PostResponse;
import com.project.questapp.responses.UserResponse;
import com.project.questapp.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/posts")
@CrossOrigin("*")
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private CommentController commentController;

    /**
     * This method gets the list of all existing posts along with their comments.
     * @return List of all existing posts.
     */
    @GetMapping("/list")
    public List<PostResponse> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        List<PostResponse> responseList = new ArrayList<>();
        for(Post post : posts) {
            PostResponse responseToSave = new PostResponse();
            //Setting text.
            responseToSave.setText(post.getText());
            //Setting title.
            responseToSave.setTitle(post.getTitle());
            //Setting userResponse
            UserResponse userResponse = new UserResponse();
            userResponse.setUserName(post.getUser().getUsername());
            responseToSave.setUserResponse(userResponse);
            //Setting commentResponseList
            responseToSave.setCommentResponseList(commentController.getAllCommentsByPostId(post.getId()));
            responseList.add(responseToSave);
        }
        return responseList;
    }

    /**
     * This method is used to get all the posts posted by a user that has the unique userId parameter as id.
     * @param userId id of the user that posted the posts.
     * @return list of all posts by the user. If the user with the userId does not exist, or the user did not post anything,
     * it returns all the posts.
     */
    @GetMapping("/list/{userId}")
    public List<Post> getAllPostsByUserId(@PathVariable Optional<Long> userId) {
        return postService.getAllPostsByUserId(userId);
    }

    /**
     * This method gets the post with the given parameter id.
     * @param postId id of the post to be returned
     * @return the post with the id.
     */
    @GetMapping("/{postId}")
    public Optional<Post> getOnePostById(@PathVariable Long postId) {
        return postService.getOnePostById(postId);
    }

    /**
     * This method gets the user of a post.
     * @param postId id of the post
     * @return the user of the post.
     */
    @GetMapping("/user")
    public String getUserByPost(@RequestParam Long postId) {
        UserGetRequest request = new UserGetRequest();
        request.setPostId(postId);
        return postService.getUserByPost(request).get().getUsername();
    }

    /**
     * Creates a post with the credentials of newPostRequest
     * @param newPostRequest carries credentials of the post
     * @return "Success!" if the post is created successfully, "Failed: Such a post with the same id already exists!" if
     * the post with the same id exists, and "Failed: Such a user does not exist!" if the user does not exist.
     */
    @PostMapping("/create")
    public String createOnePost(@RequestBody PostCreateRequest newPostRequest) {
        return postService.createOnePost(newPostRequest);
    }

    /**
     * This method is used to update one post.
     * @param postId the id of the post to be updated.
     * @param updatePost updated text and title of the post carried here
     * @return "Success!" if it is done, "Failed: No post with this id exists!" if not.
     */
    @PutMapping("/{postId}")
    public String updateOnePostById(@PathVariable Long postId, @RequestBody PostUpdateRequest updatePost) {
        return postService.updateOnePostById(postId, updatePost);
    }

    /**
     * Deleted the post with the given id.
     * @param postId id of the post to be deleted
     * @return "Success!" if it is successfully deleted, "Failed: No such post exists!" if no post exists.
     */
    @DeleteMapping("/{postId}")
    public String deleteOnePostById(@PathVariable Long postId) {
        return postService.deleteById(postId);
    }
}
