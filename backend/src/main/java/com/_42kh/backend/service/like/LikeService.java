package com._42kh.backend.service.like;

import com._42kh.backend.web.like.dto.LikeResponse;

public interface LikeService {

    LikeResponse findByPostId(Long postId, String userEmail);
    
    LikeResponse like(Long postId, String userEmail);
    
    LikeResponse likeCancel(Long postId, String userEmail);
}
