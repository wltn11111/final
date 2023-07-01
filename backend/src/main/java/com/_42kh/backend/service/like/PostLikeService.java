package com._42kh.backend.service.like;

import com._42kh.backend.config.auth.dto.SessionUser;
import com._42kh.backend.web.like.dto.PostLikeResponse;
import com._42kh.backend.web.like.dto.PostLikeWithIdResponse;

import java.util.List;

public interface PostLikeService {

    PostLikeResponse findByPostId(Long postId, SessionUser sessionUser);

    List<PostLikeWithIdResponse> findAll(SessionUser sessionUser);

    PostLikeResponse addLike(Long postId, SessionUser sessionUser);

    PostLikeResponse removeLike(Long postId, SessionUser sessionUser);
}
