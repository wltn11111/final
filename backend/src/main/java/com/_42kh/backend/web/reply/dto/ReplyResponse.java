package com._42kh.backend.web.reply.dto;

import java.time.LocalDateTime;

import com._42kh.backend.domain.reply.Reply;

import jakarta.persistence.Entity;
import lombok.Getter;

@Getter
@Entity
public class ReplyResponse {

	private final Long id;
	private final String contents;
	private final String author;
	private final LocalDateTime createdDate; 
	private final LocalDateTime modifiedDate; 

	public ReplyResponse(Reply reply) {
		this.id = reply.getId();
		this.contents = reply.getContents();
		this.author = reply.getAuthor();
		this.createdDate = reply.getCreatedDate();
		this.modifiedDate = reply.getModifiedDate();
	}
}