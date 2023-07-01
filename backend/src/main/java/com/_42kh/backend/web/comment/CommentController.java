package com._42kh.backend.web.comment;

import com._42kh.backend.config.auth.LoginUser;
import com._42kh.backend.config.auth.dto.SessionUser;
import com._42kh.backend.service.comment.CommentService;
import com._42kh.backend.web.comment.dto.CommentRequest;
import com._42kh.backend.web.comment.dto.CommentResponse;
import com._42kh.backend.web.comment.dto.CommentSaveResponse;
import com._42kh.backend.web.comment.dto.CommentUpdateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    private final CommentService commentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{post_id}")
    public CommentSaveResponse save(
        @PathVariable("post_id") Long postId,
        @RequestBody CommentRequest commentRequest,
        @LoginUser SessionUser sessionUser
    ) {
        return commentService.save(postId, commentRequest, sessionUser);
    }

    @GetMapping("/{post_id}")
    public List<CommentResponse> findByPostId(@PathVariable("post_id") Long postId) {
        return commentService.findByPostId(postId);
    }

    @PutMapping("/{comment_id}")
    public CommentUpdateResponse update(
        @PathVariable("comment_id") Long comment_id,
        @RequestBody CommentRequest commentRequest,
        @LoginUser SessionUser sessionUser
    ) {
        return commentService.update(comment_id, commentRequest, sessionUser);
    }

    @DeleteMapping("/{comment_id}")
    public void delete(
        @PathVariable("comment_id") Long comment_id,
        @LoginUser SessionUser sessionUser
    ) {
        commentService.delete(comment_id, sessionUser);
    }
}
