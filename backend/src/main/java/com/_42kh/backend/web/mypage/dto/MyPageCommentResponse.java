package com._42kh.backend.web.mypage.dto;

import com._42kh.backend.domain.comment.Comment;
import lombok.Getter;

@Getter
public class MyPageCommentResponse {

    private final Long id;
    private final Long postId;
    private final String contents;

    public MyPageCommentResponse(Comment comment) {
        id = comment.getId();
        postId = comment.getPost().getId();
        contents = comment.getContents();
    }
}
