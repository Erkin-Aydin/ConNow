package com.project.questapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.questapp.entities.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long>{
    List<Post> findByUserId(Long userId);//findBy is a "kalıp", which can be combined with properties;

}
