package com._42kh.backend.web.reply.dto;

import com._42kh.backend.domain.post.Post;
import com._42kh.backend.domain.reply.Reply;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ReplyRequest {

    private final String contents;
    private final String author;
	
    @Builder
    public ReplyRequest(
        String contents,
        String author
    ) {
    	this.contents = contents;
    	this.author = author;
    }
    
	public Reply toEntity(Post post) {
		return Reply.builder()
			.contents(contents)
			.author(author)
			.post(post)
            .build();
	}
}