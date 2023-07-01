package com._42kh.backend.domain.like;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentLikeRepository extends JpaRepository<CommentLike, CommentLikeId> {

    Optional<CommentLike> findByCommentLikeIdCommentIdAndCommentLikeIdUserId(Long commentId, Long userId);

    Long countByCommentLikeIdCommentId(Long commentId);

    Boolean existsByCommentLikeIdCommentIdAndCommentLikeIdUserId(Long commentId, Long userId);
}
