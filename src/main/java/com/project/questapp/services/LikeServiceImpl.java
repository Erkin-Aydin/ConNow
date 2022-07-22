package com.project.questapp.services;

import com.project.questapp.entities.Like;
import com.project.questapp.entities.Post;
import com.project.questapp.entities.User;
import com.project.questapp.repos.LikeRepository;
import com.project.questapp.repos.PostRepository;
import com.project.questapp.repos.UserRepository;
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
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    /**ProbLEMO
     * This function is used to get all the likes associaten with a post, using the postId of that post.
     * @param likeId the id of the post that like is associated with.
     * @return List of all likes associated with the post.
    public List<Like> getAllLikesByPostId1(Long postId) {
        return likeRepository.findByPost_Id(postId);
    }
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
    public Like createOneLike(LikeCreateRequest newLike) {
        Optional<Post> post = postRepository.findById(newLike.getPostId());
        Optional<User> user = userRepository.findById(newLike.getUserId());
        //If the user or the post does not exist, then return null.
        if(!post.isPresent() || !user.isPresent()) {
            return null;
        }
        //If both exist, then create the like, save is to the LikeRepository and return the like.
        else {
            Like toSave = new Like();
            toSave.setId(newLike.getId());
            toSave.setUser(user.get());
            toSave.setPost(post.get());
            likeRepository.save(toSave);
            return toSave;
        }
    }

    /**
     * This function is to delete a like using its id.
     * @param likeId
     */
    public void deleteOneLike(Long likeId) {
            likeRepository.deleteById(likeId);
    }
}
