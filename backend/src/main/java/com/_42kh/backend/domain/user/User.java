package com._42kh.backend.domain.user;

import com._42kh.backend.domain.BaseTime;
import com._42kh.backend.domain.like.PostLike;
import com._42kh.backend.domain.post.Post;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    private String picture;

    @Column(nullable = false, updatable = false)
    private String vendor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(
        String name,
        String email,
        String picture,
        String vendor,
        Role role
    ) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.vendor = vendor;
        this.role = role;
    }

    public User update(
        String name,
        String picture
    ) {
        this.name = name;
        this.picture = picture;
        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }

    public PostLike like(Post post) {
        return PostLike.builder()
            .post(post)
            .user(this)
            .build();
    }
}
