package com._42kh.backend.web.post.dto;

import com._42kh.backend.domain.post.Post;
import lombok.Getter;

@Getter
public class PostDeleteResponse {

    private final Long id;

    public PostDeleteResponse(Post post) {
        this.id = post.getId();
    }
}