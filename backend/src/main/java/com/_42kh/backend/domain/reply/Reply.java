package com._42kh.backend.domain.reply;

import com._42kh.backend.domain.BaseTime;
import com._42kh.backend.domain.post.Post;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "replies")
public class Reply extends BaseTime {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String contents;

	private String author;

	@ManyToOne
	@JoinColumn(name = "post_id", nullable = false)
	private Post post;

	@Builder
	public Reply(
		String contents,
		String author,
		Post post
	) {
		this.contents = contents;
		this.author = author;
		this.post = post;
	}

	public void update(String contents) {
		this.contents = contents;
	}
}