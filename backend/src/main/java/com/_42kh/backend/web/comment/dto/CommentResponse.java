package com._42kh.backend.web.comment.dto;

import java.time.LocalDateTime;

import com._42kh.backend.domain.comment.Comment;

import lombok.Getter;

@Getter
public class CommentResponse {

	private final Long id;
	private final String contents;
	private final String author;
	private final LocalDateTime createdDate;
	private final LocalDateTime modifiedDate;

	public CommentResponse(Comment comment) {
		this.id = comment.getId();
		this.contents = comment.getContents();
		this.author = comment.getAuthor();
		this.createdDate = comment.getCreatedDate();
		this.modifiedDate = comment.getModifiedDate();
	}
}