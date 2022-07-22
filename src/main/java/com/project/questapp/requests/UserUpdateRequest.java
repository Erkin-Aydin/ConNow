package com.project.questapp.requests;

import lombok.Data;

@Data
public class UserUpdateRequest {
    private String userName;
    private String password;
}
