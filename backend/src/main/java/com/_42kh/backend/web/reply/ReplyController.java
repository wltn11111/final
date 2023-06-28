package com._42kh.backend.web.reply;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com._42kh.backend.service.reply.ReplyService;
import com._42kh.backend.web.reply.dto.ReplyRequest;
import com._42kh.backend.web.reply.dto.ReplyResponse;
import com._42kh.backend.web.reply.dto.ReplySaveResponse;
import com._42kh.backend.web.reply.dto.ReplyUpdateResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/replies")
public class ReplyController {

    private final ReplyService replyService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{post_id}")
    public ReplySaveResponse save(
        @PathVariable("post_id") Long postId,
        @RequestBody ReplyRequest replyRequest
    ) {
        return replyService.save(postId, replyRequest);
    }

    @GetMapping("/{post_id}")
    public List<ReplyResponse> findByPostId(@PathVariable("post_id") Long postId) {
        return replyService.findByPostId(postId);
    }

    @PutMapping("/{id}")
    public ReplyUpdateResponse update(
        @PathVariable("id") Long id,
        @RequestBody ReplyRequest replyRequest
    ) {
        return replyService.update(id, replyRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        replyService.delete(id);
    }
}
