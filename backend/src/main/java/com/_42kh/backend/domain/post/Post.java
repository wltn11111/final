package com._42kh.backend.domain.post;

import com._42kh.backend.domain.BaseTime;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @Builder
    public Post(
        String title,
        String contents,
        String author
    ) {
        this.title = title;
        this.contents = contents;
        this.author = author;
    }
}
