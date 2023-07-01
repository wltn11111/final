package com._42kh.backend.domain.bookmark;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookmarkRepository extends JpaRepository<Bookmark, BookmarkId>{

    Optional<Bookmark> findByBookmarkIdPostIdAndBookmarkIdUserId(Long postId, Long userId);

    Boolean existsByBookmarkIdPostIdAndBookmarkIdUserId(Long postId, Long userId);
}
