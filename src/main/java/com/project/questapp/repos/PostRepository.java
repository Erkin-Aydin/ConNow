package com.project.questapp.repos;

import com.project.questapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import com.project.questapp.entities.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

    /**
     *
     * @param userId
     * @return
     */
    List<Post> findByUserId(Long userId);//findBy is a "kalıp", which can be combined with properties;
}
