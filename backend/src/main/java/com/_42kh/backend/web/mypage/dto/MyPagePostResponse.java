package com._42kh.backend.web.mypage.dto;

import com._42kh.backend.domain.post.Post;
import lombok.Getter;

@Getter
public class MyPagePostResponse {

    private final Long id;
    private final String title;

    public MyPagePostResponse(Post post) {
        id = post.getId();
        title = post.getTitle();
    }
}
