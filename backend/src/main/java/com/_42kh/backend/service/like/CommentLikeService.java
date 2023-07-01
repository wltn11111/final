package com._42kh.backend.service.like;

import com._42kh.backend.config.auth.dto.SessionUser;
import com._42kh.backend.web.like.dto.CommentLikeResponse;
import com._42kh.backend.web.like.dto.CommentLikeWithIdResponse;

import java.util.List;

public interface CommentLikeService {

    List<CommentLikeWithIdResponse> findAllByPostId(Long postId, SessionUser sessionUser);

    CommentLikeResponse addLike(Long commentId, SessionUser sessionUser);

    CommentLikeResponse removeLike(Long commentId, SessionUser sessionUser);
}
