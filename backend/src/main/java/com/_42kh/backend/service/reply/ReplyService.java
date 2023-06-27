package com._42kh.backend.service.reply;

import java.util.List;

import com._42kh.backend.web.reply.dto.ReplyRequest;
import com._42kh.backend.web.reply.dto.ReplyResponse;
import com._42kh.backend.web.reply.dto.ReplySaveResponse;
import com._42kh.backend.web.reply.dto.ReplyUpdateResponse;

public interface ReplyService {

    ReplySaveResponse save(Long postId, ReplyRequest replyRequest);

    List<ReplyResponse> findByPostId(Long postId);

    List<ReplyResponse> findAll();

    ReplyUpdateResponse update(Long id, ReplyRequest replyRequest);

    void delete(Long id);
}