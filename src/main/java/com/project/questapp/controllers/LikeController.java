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

    /*
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }
     */


    /*
    @GetMapping("/commentList")
    public List<Like> getAllLikesByPostId(@RequestParam Long postId) {
        return likeService.getAllLikesByPostId1(postId);
    }
     */
    @GetMapping("/{likeId}")
    public Optional<Like> getOneLikeById(@PathVariable Long likeId) {
        return likeService.getOneLikeById(likeId);
    }

    @PostMapping("/create")
    public Like createOneLike(@RequestBody LikeCreateRequest newLike) {
        return likeService.createOneLike(newLike);
    }

    @DeleteMapping("/delete/{likeId}")
    public void deleteOneLike(@PathVariable Long likeId) {
        likeService.deleteOneLike(likeId);
    }

}
