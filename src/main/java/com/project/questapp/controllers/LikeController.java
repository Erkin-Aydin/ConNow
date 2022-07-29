package com.project.questapp.controllers;

import com.project.questapp.entities.Like;
import com.project.questapp.requests.LikeCreateRequest;
import com.project.questapp.services.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/like")
public class LikeController {

    @Autowired
    private LikeService likeService;


    /**
     * This method is used to get all the likes under a post.
     * @param postId the id of the post.
     * @return the list of the posts under a post.
    */
    @GetMapping("/likes/{postId}")
    public List<Like> getAllLikesByPostId(@PathVariable Optional<Long> postId) {
        return likeService.getAllLikesByPostId(postId);
    }
    /**
     * This method gets one like by its id.
     * @param likeId id of the like to be returned.
     * @return the like, if it exists. If it doesn't, then null
     */
    @GetMapping("/{likeId}")
    public Optional<Like> getOneLikeById(@PathVariable Long likeId) {
        return likeService.getOneLikeById(likeId);
    }

    /**
     * This method creates a like under a post with respect to parameter LikeCreateRequest.
     * @param newLike carries the credentials of the like to be created.
     * @return "Success!" if like is created successfully, a fail message with relevant context if not.
     */
    @PostMapping("/create")
    public String createOneLike(@RequestBody LikeCreateRequest newLike) {
        return likeService.createOneLike(newLike);
    }

    /**
     * Deletes a like by its id.
     * @param likeId id of the like to be deleted
     * @return "Success!" if like is deleted successfully, a fail message with relevant context if not.
     */
    @DeleteMapping("/delete/{likeId}")
    public String deleteOneLike(@PathVariable Long likeId) {
        return likeService.deleteOneLike(likeId);
    }

}
