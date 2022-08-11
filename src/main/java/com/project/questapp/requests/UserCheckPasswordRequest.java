package com.project.questapp.requests;

import lombok.Data;

@Data
public class UserCheckPasswordRequest {
    private String email;
    private String password;
}
