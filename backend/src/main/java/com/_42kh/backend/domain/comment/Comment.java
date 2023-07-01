package com._42kh.backend.domain.comment;

import com._42kh.backend.domain.BaseTime;
import com._42kh.backend.domain.post.Post;
import com._42kh.backend.domain.user.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.NoSuchElementException;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "comments")
public class Comment extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false, updatable = false)
    private Post post;

    @Builder
    public Comment(String contents) {
        this.contents = contents;
    }

    public Comment setContents(String contents) {
        this.contents = contents;
        return this;
    }

    public Comment setUser(User user) {
        this.user = user;
        return this;
    }

    public Comment setPost(Post post) {
        this.post = post;
        return this;
    }

    public Comment validateUser(User user) {
        if (!this.user.getId().equals(user.getId())) {
            throw new NoSuchElementException();
        }
        return this;
    }
}