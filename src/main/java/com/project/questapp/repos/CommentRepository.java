package com.project.questapp.repos;

import com.project.questapp.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import com.project.questapp.entities.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{
    List<Comment> findByPostId(Long postId);

    //List<Comment> findByUserId(Long userId);//findBy is a "kalıp", which can be combined with properties;
}
