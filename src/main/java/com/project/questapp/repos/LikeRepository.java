package com.project.questapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.questapp.entities.Like;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long>{
    /*
    List<Like> findByPost_Id(Long postId);
    */
}
