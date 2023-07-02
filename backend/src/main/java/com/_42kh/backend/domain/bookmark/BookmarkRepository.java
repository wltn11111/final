package com._42kh.backend.domain.bookmark;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookmarkRepository extends JpaRepository<Bookmark, BookmarkId>{

    Optional<Bookmark> findByBookmarkIdPostIdAndBookmarkIdUserId(Long postId, Long userId);

    Boolean existsByBookmarkIdPostIdAndBookmarkIdUserId(Long postId, Long userId);

    List<Bookmark> findByBookmarkIdUserId(Long userId, Sort sort);
}
