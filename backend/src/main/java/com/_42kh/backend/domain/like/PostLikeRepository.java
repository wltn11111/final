package com._42kh.backend.domain.like;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostLikeRepository extends JpaRepository<PostLike, PostLikeId> {

    List<PostLike> findByPostLikeIdPostId(Long id);

    Long countByPostLikeIdPostId(Long postId);

    Boolean existsByPostLikeIdPostIdAndPostLikeIdUserId(Long postId, Long userId);
}