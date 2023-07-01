package com._42kh.backend.web.comment.dto;

import com._42kh.backend.domain.comment.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CommentRequest {

    private String contents;

    @Builder
    public CommentRequest(String contents) {
    	this.contents = contents;
    }

	public Comment toEntity() {
		return Comment.builder()
			.contents(contents)
            .build();
	}
}