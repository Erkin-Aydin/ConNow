package com.project.questapp.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentCreateRequest {
    private Long id;
    private Long postId;
    private Long userId;
    private String text;
}
