package com._42kh.backend.web.reply.dto;

import java.time.LocalDateTime;

import com._42kh.backend.domain.reply.Reply;

import lombok.Getter;

@Getter
public class ReplyUpdateResponse {

    private final String contents;
    private final LocalDateTime modifiedDate; 

    public ReplyUpdateResponse(Reply reply) {
        this.contents = reply.getContents();
        this.modifiedDate = reply.getModifiedDate();
    }
}
