package com._42kh.backend.web.mypage.dto;

import com._42kh.backend.domain.comment.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MyPageCommentResponse {

    private final Long id;
    private final String contents;
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;

    public MyPageCommentResponse(Comment comment) {
        id = comment.getId();
        contents = comment.getContents();
        createdDate = comment.getCreatedDate();
        modifiedDate = comment.getModifiedDate();
    }
}
