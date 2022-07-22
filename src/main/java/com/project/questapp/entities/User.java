package com.project.questapp.entities;

import com.project.questapp.requests.UserCreateRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String userName;
    private String password;



}
