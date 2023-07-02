package com._42kh.backend.web.like.dto;

import lombok.Getter;

@Getter
public class CommentLikeWithIdResponse {

    private final Long commentId;
    private final Boolean isLike;
    private final Long count;

    public CommentLikeWithIdResponse(
        Long commentId,
        Boolean isLike,
        Long count
    ) {
        this.commentId = commentId;
        this.isLike = isLike;
        this.count = count;
    }
}