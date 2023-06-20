package com._42kh.backend.web.post.dto;

import com._42kh.backend.domain.post.Post;
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

    public Post toEntity() {
        return Post.builder()
            .title(title)
            .contents(contents)
            .build();
    }
}
