package com._42kh.backend.web.like.dto;

import lombok.Getter;

@Getter
public class PostLikeWithIdResponse {

    private final Long id;
    private final Boolean isLike;
    private final Long count;

    public PostLikeWithIdResponse(
        Long id,
        Boolean isLike,
        Long count
    ) {
        this.id = id;
        this.isLike = isLike;
        this.count = count;
    }
}
