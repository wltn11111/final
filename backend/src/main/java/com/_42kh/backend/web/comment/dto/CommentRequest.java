package com._42kh.backend.web.comment.dto;

import com._42kh.backend.domain.comment.Comment;
import com._42kh.backend.domain.post.Post;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CommentRequest {

    private final String contents;
    private final String author;

    @Builder
    public CommentRequest(
        String contents,
        String author
    ) {
    	this.contents = contents;
    	this.author = author;
    }

	public Comment toEntity(Post post) {
		return Comment.builder()
			.contents(contents)
			.author(author)
			.post(post)
            .build();
	}
}