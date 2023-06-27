package com._42kh.backend.web.reply.dto;

import java.time.LocalDateTime;

import com._42kh.backend.domain.reply.Reply;

import lombok.Getter;

@Getter
public class ReplySaveResponse {

    private final Long id;
    private final String contents;
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;

    public ReplySaveResponse(Reply reply) {
        this.id = reply.getId();
        this.contents = reply.getContents();
        this.createdDate = reply.getCreatedDate();
        this.modifiedDate = reply.getModifiedDate();
    }
}
