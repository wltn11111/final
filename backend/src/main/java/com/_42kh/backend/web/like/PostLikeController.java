package com._42kh.backend.web.like;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com._42kh.backend.config.auth.LoginUser;
import com._42kh.backend.config.auth.dto.SessionUser;
import com._42kh.backend.service.like.PostLikeService;
import com._42kh.backend.web.like.dto.PostLikeResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/likes/posts")
public class PostLikeController {

    private final PostLikeService postLikeService;

    @GetMapping("/{post_id}")
    public PostLikeResponse findByPostId(
        @PathVariable("post_id") Long postId,
        @LoginUser SessionUser user
    ) {
        return postLikeService.findByPostId(postId, user.getEmail());
    }

    @PostMapping("/{post_id}")
    public PostLikeResponse like(
        @PathVariable("post_id") Long postId,
        @LoginUser SessionUser user
    ) {
        return postLikeService.like(postId, user.getEmail());
    }

    @DeleteMapping("/{post_id}")
    public PostLikeResponse likeCancel(
        @PathVariable("post_id") Long postId,
        @LoginUser SessionUser user
    ) {
        return postLikeService.likeCancel(postId, user.getEmail());
    }
}
