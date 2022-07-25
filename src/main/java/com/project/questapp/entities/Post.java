package com.project.questapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name="post")
@Data
public class Post {

    @Id
    private Long id;
    public String title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id", nullable=false) // user can't be null
    @OnDelete(action = OnDeleteAction.CASCADE) //when a user is deleted, all the posts of its are also deleted
    @JsonIgnore
    public User user;

    @Column(columnDefinition="text")
    public String text;
}
