package com._42kh.backend.domain.like;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, LikeId> {
    
    List<Like> findByLikeIdPostId(Long id);
    
    Long countByLikeIdPostId(Long postId);
    
    Boolean existsByLikeIdUserEmail(String userEmail);
}