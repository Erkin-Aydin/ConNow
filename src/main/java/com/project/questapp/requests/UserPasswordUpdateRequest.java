package com.project.questapp.requests;

import lombok.Data;

@Data
public class UserPasswordUpdateRequest {
    private String email;
    private String password;
}
