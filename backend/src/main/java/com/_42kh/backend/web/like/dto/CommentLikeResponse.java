package com._42kh.backend.web.like.dto;

import lombok.Getter;

@Getter
public class CommentLikeResponse {

    private final Boolean isLike;
    private final Long count;

    public CommentLikeResponse(
        Boolean isLike,
        Long count
    ) {
        this.isLike = isLike;
        this.count = count;
    }
}