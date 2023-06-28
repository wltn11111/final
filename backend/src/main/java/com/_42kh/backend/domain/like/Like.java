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
@Table(name = "likes")
public class Like {


    @EmbeddedId
    private LikeId likeId;
    
    @Builder
    public Like(Post post, User user) {
        likeId = LikeId.builder()
            .post(post)
            .user(user)
            .build();
    }
}