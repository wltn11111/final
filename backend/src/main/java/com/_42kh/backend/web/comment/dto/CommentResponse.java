package com._42kh.backend.web.comment.dto;

import com._42kh.backend.domain.comment.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponse {

	private final Long id;
	private final String contents;
	private final String author;
    private final String email;
    private final String picture;
	private final LocalDateTime createdDate;
	private final LocalDateTime modifiedDate;

	public CommentResponse(Comment comment) {
		id = comment.getId();
		contents = comment.getContents();
		author = comment.getUser().getNickname();
        email = comment.getUser().getEmail();
        picture = comment.getUser().getPicture();
		createdDate = comment.getCreatedDate();
		modifiedDate = comment.getModifiedDate();
	}
}