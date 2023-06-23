package com._42kh.backend.service.reply;

import java.util.List;

import com._42kh.backend.web.reply.dto.ReplyRequest;
import com._42kh.backend.web.reply.dto.ReplyResponse;

public interface ReplyService {

    Long save(Long postId, ReplyRequest replyRequest);
    
    List<ReplyResponse> findAll();
    
    Long update(Long id, ReplyRequest replyRequest);
    
    Long delete(Long id);
}