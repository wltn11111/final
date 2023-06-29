package com._42kh.backend.service.like;

import com._42kh.backend.web.like.dto.PostLikeResponse;

public interface PostLikeService {

    PostLikeResponse findByPostId(Long postId, String userEmail);

    PostLikeResponse like(Long postId, String userEmail);

    PostLikeResponse likeCancel(Long postId, String userEmail);
}
