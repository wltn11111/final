package com._42kh.backend.web.bookmark.dto;

import lombok.Getter;

@Getter
public class BookmarkWithIdResponse {

    private final Long id;
    private final Boolean isSubscribed;

    public BookmarkWithIdResponse(
        Long id,
        Boolean isSubscribed
    ) {
        this.id = id;
        this.isSubscribed = isSubscribed;
    }
}
