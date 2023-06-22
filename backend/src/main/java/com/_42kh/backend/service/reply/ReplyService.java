package com._42kh.backend.service.reply;

import com._42kh.backend.web.reply.dto.ReplyRequest;

public interface ReplyService {

    Long save(Long postId, ReplyRequest replyRequest);
    
    Long update(Long id, ReplyRequest replyRequest);
    
    Long delete(Long id);
}