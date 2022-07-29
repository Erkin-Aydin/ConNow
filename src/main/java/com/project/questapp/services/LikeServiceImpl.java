package com.project.questapp.services;

import com.project.questapp.entities.Like;
import com.project.questapp.entities.Post;
import com.project.questapp.entities.User;
import com.project.questapp.repos.LikeRepository;
import com.project.questapp.requests.LikeCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeServiceImpl implements LikeService{

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    /**
     * Gets all likes under a post. If such a post does not exist, then returns all existing likes.
     * @param postId id of the post.
     * @return all likes under the post, all existing likes if such a post does not exist.
    */
    public List<Like> getAllLikesByPostId(Optional<Long> postId) {
        Optional<Post> post = postService.getOnePostById(postId.get());
        if(post.isEmpty()) {
            return likeRepository.findAll();
        }
        else {
            List<Like> likes = likeRepository.findByPostId(postId.get());
            return likes;
        }
    }

    /**
     * This method gets one like by its id.
     * @param likeId id of the like to be returned.
     * @return the like, if it exists. If it doesn't, then null
     */
    public Optional<Like> getOneLikeById(Long likeId) {
        return likeRepository.findById(likeId);
    }

    /**
     * If the user and the post with the postId and userId giver in the parameter LikeCreateRequest exists, then
     * the request is accepted, like is created and saved to the likeRepository, and returned. If not, simply null is
     * returned.
     * @param newLike
     * @return null if user or the post does not exist, newly created like if they exist.
     */
    public String createOneLike(LikeCreateRequest newLike) {
        Optional<Post> post = postService.getOnePostById(newLike.getPostId());
        Optional<User> user = userService.getOneUser(newLike.getUserId());
        //If the user or the post does not exist, then return a fail message with relevant context.
        if(post.isEmpty()) {
            return "Failed: Such a post does not exist!";
        }
        else if(user.isEmpty()) {
            return "Failed: Such a user does not exist!";
        }
        //If both exist, then create the like, save is to the LikeRepository and return the like.
        else {
            Like toSave = new Like();
            toSave.setId(newLike.getId());
            toSave.setUser(user.get());
            toSave.setPost(post.get());
            likeRepository.save(toSave);
            return "Success!";
        }
    }

    /**
     * This function is to delete a like using its id.
     * @param likeId
     */
    public String deleteOneLike(Long likeId) {
        Optional<Like> like = likeRepository.findById(likeId);
        if(like.isEmpty()) {
            return "Failed: Like does not exist!";
        }
        else {
            likeRepository.deleteById(likeId);
            return "Success!";
        }
    }
}
