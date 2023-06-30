package com._42kh.backend.domain.post;

import com._42kh.backend.domain.BaseTime;
import com._42kh.backend.domain.comment.Comment;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor
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

    private String author;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private final Set<Comment> comments = new HashSet<>();

    @Builder
    public Post(
        String title,
        String contents,
        String author,
        Category category
    ) {
        this.title = title;
        this.contents = contents;
        this.author = author;
        this.category = category;
    }

    public void update(String title, String contents, Category category) {
        this.title = title;
        this.contents = contents;
        this.category = category;
    }
}
