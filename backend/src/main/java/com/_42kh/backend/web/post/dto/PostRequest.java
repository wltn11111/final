package com._42kh.backend.web.post.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PostRequest {

    private final String title;
    private final String contents;

    @Builder
    public PostRequest(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
