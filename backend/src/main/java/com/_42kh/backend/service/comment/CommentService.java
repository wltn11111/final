package com._42kh.backend.service.comment;

import java.util.List;

import com._42kh.backend.web.comment.dto.CommentRequest;
import com._42kh.backend.web.comment.dto.CommentResponse;
import com._42kh.backend.web.comment.dto.CommentSaveResponse;
import com._42kh.backend.web.comment.dto.CommentUpdateResponse;

public interface CommentService {

    CommentSaveResponse save(Long postId, CommentRequest commentRequest);

    List<CommentResponse> findByPostId(Long postId);

    CommentUpdateResponse update(Long id, CommentRequest commentRequest);

    void delete(Long id);
}