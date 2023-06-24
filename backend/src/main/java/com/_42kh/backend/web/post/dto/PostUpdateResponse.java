package com._42kh.backend.web.post.dto;

import java.time.LocalDateTime;

import com._42kh.backend.domain.post.Post;

import lombok.Getter;

@Getter
public class PostUpdateResponse {
    
    private final String title;
    private final String contents;
    private final LocalDateTime modifiedDate;
    
    public PostUpdateResponse(Post post) {
        this.title = post.getTitle();
        this.contents = post.getContents();
        this.modifiedDate = post.getModifiedDate();
    }

}
