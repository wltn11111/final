package com._42kh.backend.web.post.dto;

import com._42kh.backend.domain.post.Category;
import com._42kh.backend.domain.post.Post;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostRequest {

    private final String title;
    private final String contents;
    private final Category category;

    @Builder
    public PostRequest(
        String title,
        String contents,
        Category category
    ) {
        this.title = title;
        this.contents = contents;
        this.category = category;
    }

    public Post toEntity() {
        return Post.builder()
            .title(title)
            .contents(contents)
            .category(category)
            .build();
    }
}
