package com._42kh.backend.domain.bookmark;

import com._42kh.backend.domain.BaseTime;
import com._42kh.backend.domain.post.Post;
import com._42kh.backend.domain.user.User;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "bookmarks")
public class Bookmark extends BaseTime {

    @EmbeddedId
    private BookmarkId bookmarkId;

    public Bookmark(Post post, User user) {
        bookmarkId = new BookmarkId(post, user);
    }
}