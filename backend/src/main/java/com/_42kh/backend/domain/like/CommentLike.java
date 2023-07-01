package com._42kh.backend.domain.like;

import com._42kh.backend.domain.comment.Comment;
import com._42kh.backend.domain.user.User;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "comment_likes")
public class CommentLike {

    @EmbeddedId
    private CommentLikeId commentLikeId;

    public CommentLike(Comment comment, User user) {
        commentLikeId = new CommentLikeId(comment, user);
    }
}
