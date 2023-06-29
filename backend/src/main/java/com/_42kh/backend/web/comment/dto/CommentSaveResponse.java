package com._42kh.backend.web.comment.dto;

import java.time.LocalDateTime;

import com._42kh.backend.domain.comment.Comment;

import lombok.Getter;

@Getter
public class CommentSaveResponse {

    private final Long id;
    private final String contents;
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;

    public CommentSaveResponse(Comment comment) {
        this.id = comment.getId();
        this.contents = comment.getContents();
        this.createdDate = comment.getCreatedDate();
        this.modifiedDate = comment.getModifiedDate();
    }
}
