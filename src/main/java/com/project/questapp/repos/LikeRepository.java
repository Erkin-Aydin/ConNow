package com.project.questapp.repos;

import com.project.questapp.entities.Comment;
import com.project.questapp.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import com.project.questapp.entities.Like;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long>{
    List<Like> findByPostId(Long postId);

}
