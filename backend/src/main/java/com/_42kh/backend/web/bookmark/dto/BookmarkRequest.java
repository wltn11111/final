package com._42kh.backend.web.bookmark.dto;

import com._42kh.backend.domain.Bookmark.Bookmark;
import com._42kh.backend.domain.post.Post;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BookmarkRequest {

    private String name;
    private Post post;
    
    @Builder
    public BookmarkRequest(String name, Post post) {
        this.name = name;
        this.post = post;
    }
    
    public Bookmark toEntity() {
        return Bookmark.builder()
            .name(name)
            .post(post)
            .build();             
    }
}
