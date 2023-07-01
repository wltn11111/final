package com._42kh.backend.web.comment.dto;

import com._42kh.backend.domain.comment.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentUpdateResponse {

    private final String contents;
    private final LocalDateTime modifiedDate;

    public CommentUpdateResponse(Comment comment) {
        this.contents = comment.getContents();
        this.modifiedDate = comment.getModifiedDate();
    }
}
