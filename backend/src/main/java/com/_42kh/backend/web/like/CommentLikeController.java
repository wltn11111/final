package com._42kh.backend.web.like;

import com._42kh.backend.config.auth.LoginUser;
import com._42kh.backend.config.auth.dto.SessionUser;
import com._42kh.backend.service.like.CommentLikeService;
import com._42kh.backend.web.like.dto.CommentLikeResponse;
import com._42kh.backend.web.like.dto.CommentLikeWithIdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/likes/comments")
public class CommentLikeController {

    private final CommentLikeService commentLikeService;

    @GetMapping("/{post_id}")
    public List<CommentLikeWithIdResponse> findAllByPostId(
        @PathVariable("post_id") Long postId,
        @LoginUser SessionUser sessionUser
    ) {
        return commentLikeService.findAllByPostId(postId, sessionUser);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{comment_id}")
    public CommentLikeResponse like(
        @PathVariable("comment_id") Long commentId,
        @LoginUser SessionUser sessionUser
    ) {
        return commentLikeService.addLike(commentId, sessionUser);
    }

    @DeleteMapping("/{comment_id}")
    public CommentLikeResponse likeCancel(
        @PathVariable("comment_id") Long commentId,
        @LoginUser SessionUser sessionUser
    ) {
        return commentLikeService.removeLike(commentId, sessionUser);
    }
}
