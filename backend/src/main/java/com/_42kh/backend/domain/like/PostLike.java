package com._42kh.backend.domain.like;

import com._42kh.backend.domain.post.Post;
import com._42kh.backend.domain.user.User;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "post_likes")
public class PostLike {


    @EmbeddedId
    private PostLikeId postLikeId;

    @Builder
    public PostLike(Post post, User user) {
        postLikeId = PostLikeId.builder()
            .post(post)
            .user(user)
            .build();
    }
}