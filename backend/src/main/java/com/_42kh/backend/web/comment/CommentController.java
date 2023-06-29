package com._42kh.backend.web.comment;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com._42kh.backend.service.comment.CommentService;
import com._42kh.backend.web.comment.dto.CommentRequest;
import com._42kh.backend.web.comment.dto.CommentResponse;
import com._42kh.backend.web.comment.dto.CommentSaveResponse;
import com._42kh.backend.web.comment.dto.CommentUpdateResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    private final CommentService commentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{post_id}")
    public CommentSaveResponse save(
        @PathVariable("post_id") Long postId,
        @RequestBody CommentRequest commentRequest
    ) {
        return commentService.save(postId, commentRequest);
    }

    @GetMapping("/{post_id}")
    public List<CommentResponse> findByPostId(@PathVariable("post_id") Long postId) {
        return commentService.findByPostId(postId);
    }

    @PutMapping("/{id}")
    public CommentUpdateResponse update(
        @PathVariable("id") Long id,
        @RequestBody CommentRequest commentRequest
    ) {
        return commentService.update(id, commentRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        commentService.delete(id);
    }
}
