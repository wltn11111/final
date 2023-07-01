package com._42kh.backend.domain.user;

import com._42kh.backend.domain.BaseTime;
import com._42kh.backend.domain.bookmark.Bookmark;
import com._42kh.backend.domain.comment.Comment;
import com._42kh.backend.domain.like.CommentLike;
import com._42kh.backend.domain.like.PostLike;
import com._42kh.backend.domain.post.Post;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "users")
public class User extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String nickname;

    private String picture;

    @Column(updatable = false)
    private String vendor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private final Set<Post> posts = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private final Set<Comment> comments = new HashSet<>();

    @OneToMany(mappedBy = "bookmarkId.user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private final Set<Bookmark> bookmarks = new HashSet<>();

    @OneToMany(mappedBy = "postLikeId.user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private final Set<PostLike> postLikes = new HashSet<>();

    @OneToMany(mappedBy = "commentLikeId.user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private final Set<CommentLike> commentLikes = new HashSet<>();

    @Builder
    public User(
        String email,
        String nickname,
        String picture,
        String vendor,
        Role role
    ) {
        this.email = email;
        this.nickname = nickname;
        this.picture = picture;
        this.vendor = vendor;
        this.role = role;
    }

    public User update(
        String nickname,
        String picture
    ) {
        this.nickname = nickname;
        this.picture = picture;
        return this;
    }

    public String getRoleKey() {
        return role.getKey();
    }
}
