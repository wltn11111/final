package com._42kh.backend.web.mypage.dto;

import com._42kh.backend.domain.post.Category;
import com._42kh.backend.domain.post.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MyPagePostResponse {

    private final Long id;
    private final String title;
    private final String contents;
    private final Category category;
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;

    public MyPagePostResponse(Post post) {
        id = post.getId();
        title = post.getTitle();
        contents = post.getContents();
        category = post.getCategory();
        createdDate = post.getCreatedDate();
        modifiedDate = post.getModifiedDate();
    }
}
