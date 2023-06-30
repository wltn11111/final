package com._42kh.backend.web.post.dto;

import java.time.LocalDateTime;

import com._42kh.backend.domain.post.Category;
import com._42kh.backend.domain.post.Post;

import lombok.Getter;

@Getter
public class PostSaveResponse {

    private final Long id;
    private final String title;
    private final String contents;
    private final Category category;
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;

    public PostSaveResponse(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.contents = post.getContents();
        this.category = post.getCategory();
        this.createdDate = post.getCreatedDate();
        this.modifiedDate = post.getModifiedDate();
    }
}
