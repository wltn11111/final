package com._42kh.backend.web.bookmark.dto;

import lombok.Getter;

@Getter
public class BookmarkWithIdResponse {

    private final Long postId;
    private final Boolean isSubscribed;

    public BookmarkWithIdResponse(
        Long postId,
        Boolean isSubscribed
    ) {
        this.postId = postId;
        this.isSubscribed = isSubscribed;
    }
}
