package com._42kh.backend.domain.post;

import com._42kh.backend.domain.BaseTime;
import com._42kh.backend.domain.user.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.NoSuchElementException;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "posts")
public class Post extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String contents;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User user;

    @Builder
    public Post(
        String title,
        String contents,
        Category category
    ) {
        this.title = title;
        this.contents = contents;
        this.category = category;
    }

    public Post setTitle(String title) {
        this.title = title;
        return this;
    }

    public Post setContents(String contents) {
        this.contents = contents;
        return this;
    }

    public Post setCategory(Category category) {
        this.category = category;
        return this;
    }

    public Post setUser(User user) {
        this.user = user;
        return this;
    }

    public Post validateUser(User user) {
        if (!this.user.getId().equals(user.getId())) {
            throw new NoSuchElementException();
        }
        return this;
    }
}
