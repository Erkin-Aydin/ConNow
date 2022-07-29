package com.project.questapp.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name="comment")
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) //One post can contain many comments
    @JoinColumn(name="post_id", nullable=false) // post can't be null
    @OnDelete(action = OnDeleteAction.CASCADE) //when a post is deleted, all the comments of its are also deleted
    @JsonIgnore
    public Post post;

    @ManyToOne(fetch = FetchType.LAZY) //One user can have many comments
    @JoinColumn(name="user_id", nullable=false) // user can't be null
    @OnDelete(action = OnDeleteAction.CASCADE) //when a user is deleted, all the posts of its are also deleted
    @JsonIgnore
    public User user;

    @Column(columnDefinition="text")
    public String text;
}
