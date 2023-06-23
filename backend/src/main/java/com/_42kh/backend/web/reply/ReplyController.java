package com._42kh.backend.web.reply;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com._42kh.backend.service.reply.ReplyService;
import com._42kh.backend.web.reply.dto.ReplyRequest;
import com._42kh.backend.web.reply.dto.ReplyResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/replies")
public class ReplyController {

    private final ReplyService replyService;

    @PostMapping("/{post_id}")
    public Long save(
        @PathVariable("post_id") Long postId,
        @RequestBody ReplyRequest replyRequest
    ) {
        return replyService.save(postId, replyRequest);
    }

    @GetMapping
    public List<ReplyResponse> findAll() {
        return replyService.findAll();
    }

    @PutMapping("/{id}")
    public Long update(
        @PathVariable("id") Long id,
        @RequestBody ReplyRequest replyRequest
    ) {
        return replyService.update(id, replyRequest);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable("id") Long id) {
        return replyService.delete(id);
    }
}
