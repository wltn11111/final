package com._42kh.backend.service.comment;

import com._42kh.backend.config.auth.dto.SessionUser;
import com._42kh.backend.web.comment.dto.CommentRequest;
import com._42kh.backend.web.comment.dto.CommentResponse;
import com._42kh.backend.web.comment.dto.CommentSaveResponse;
import com._42kh.backend.web.comment.dto.CommentUpdateResponse;

import java.util.List;

public interface CommentService {

    CommentSaveResponse save(Long postId, CommentRequest commentRequest, SessionUser sessionUser);

    List<CommentResponse> findByPostId(Long postId);

    CommentUpdateResponse update(Long commentId, CommentRequest commentRequest, SessionUser sessionUser);

    void delete(Long commentId, SessionUser sessionUser);
}