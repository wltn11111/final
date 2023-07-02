package com._42kh.backend.web.like.dto;

import lombok.Getter;

@Getter
public class PostLikeWithIdResponse {

    private final Long postId;
    private final Boolean isLike;
    private final Long count;

    public PostLikeWithIdResponse(
        Long postId,
        Boolean isLike,
        Long count
    ) {
        this.postId = postId;
        this.isLike = isLike;
        this.count = count;
    }
}
