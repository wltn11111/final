package com._42kh.backend.web.like.dto;

import lombok.Getter;

@Getter
public class LikeResponse {

    private Long postId;
    private Long count;
    private Boolean isLike;
    
    public LikeResponse(
        Long postId,
        Long count,
        Boolean isLike
    ) {
        this.postId = postId;
        this.count = count;
        this.isLike = isLike;
    }
}
