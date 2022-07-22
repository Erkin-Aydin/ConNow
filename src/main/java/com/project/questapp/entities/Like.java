package com.project.questapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name="p_like")
@Data
public class Like {

    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) //One post can contain many likes
    @JoinColumn(name="post_id", nullable=false) // post can't be null
    @OnDelete(action = OnDeleteAction.CASCADE) //when a post is deleted, all the comments of its are also deleted
    @JsonIgnore
    Post Post;

    @ManyToOne(fetch = FetchType.LAZY) //One user can have many likes
    @JoinColumn(name="user_id", nullable=false) // user can't be null
    @OnDelete(action = OnDeleteAction.CASCADE) //when a user is deleted, all the posts of its are also deleted
    @JsonIgnore
    User user;
}
