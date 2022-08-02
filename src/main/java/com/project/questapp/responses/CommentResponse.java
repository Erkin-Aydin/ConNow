package com.project.questapp.responses;

import lombok.Data;

@Data
public class CommentResponse {
    private String userName;
    private String title;
    private PostResponse postResponse;
}
