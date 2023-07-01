package com._42kh.backend.web.bookmark.dto;

import lombok.Getter;

@Getter
public class BookmarkResponse {

    private final Boolean isSubscribed;

    public BookmarkResponse(Boolean isSubscribed) {
        this.isSubscribed = isSubscribed;
    }
}
