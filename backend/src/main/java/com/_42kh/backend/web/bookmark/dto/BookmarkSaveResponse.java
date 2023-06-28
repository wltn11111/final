package com._42kh.backend.web.bookmark.dto;

import com._42kh.backend.domain.Bookmark.Bookmark;

import lombok.Getter;

@Getter
public class BookmarkSaveResponse {

    private final Long id;
    
    private final String name;

    public BookmarkSaveResponse(Bookmark bookmark) {
        this.id = bookmark.getId();
        this.name = bookmark.getName();
    }
    
    
}
