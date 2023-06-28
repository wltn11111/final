package com._42kh.backend.web.bookmark.dto;

import com._42kh.backend.domain.Bookmark.Bookmark;

import lombok.Getter;

@Getter
public class BookmarkResponse {

    private final Long id;
    private final String name;
    
    
    public BookmarkResponse(Bookmark bookmark) {
        this.id = bookmark.getId();
        this.name = bookmark.getName();
    }
}
