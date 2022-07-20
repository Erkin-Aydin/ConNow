package com.project.questapp.requests;

import lombok.Data;

@Data
public class UserCreateRequest {

    private Long id;
    private String userName;
    private String password;
}
