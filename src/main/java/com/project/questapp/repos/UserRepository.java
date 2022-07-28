package com.project.questapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.questapp.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    /**
     *
     * @param user
     * @return
     */
    User save(User user);
}
