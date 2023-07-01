package com._42kh.backend.domain.like;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostLikeRepository extends JpaRepository<PostLike, PostLikeId> {

    Optional<PostLike> findByPostLikeIdPostIdAndPostLikeIdUserId(Long postId, Long userId);

    Long countByPostLikeIdPostId(Long postId);

    Boolean existsByPostLikeIdPostIdAndPostLikeIdUserId(Long postId, Long userId);
}