package com.project.questapp.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LikeCreateRequest {
    private Long id;
    private Long postId;
    private Long userId;
}