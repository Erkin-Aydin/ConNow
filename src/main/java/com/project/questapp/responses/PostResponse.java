package com.project.questapp.responses;

import com.project.questapp.entities.Comment;
import lombok.Data;

import java.util.List;

@Data
public class PostResponse {
    private String title;
    private String text;
    private UserResponse userResponse;
    private List<CommentResponse> commentResponseList;
}
