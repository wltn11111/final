package com._42kh.backend.web.like;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com._42kh.backend.config.auth.LoginUser;
import com._42kh.backend.config.auth.dto.SessionUser;
import com._42kh.backend.service.like.LikeService;
import com._42kh.backend.web.like.dto.LikeResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/likes")
public class LikeController {
    
    private final LikeService likeService;
    
    @GetMapping("/{post_id}")
    public LikeResponse findByPostId(
        @PathVariable("post_id") Long postId,
        @LoginUser SessionUser user
    ) {
        return likeService.findByPostId(postId, user.getEmail());
    }
    
    @PostMapping("/{post_id}")
    public LikeResponse like(
        @PathVariable("post_id") Long postId,
        @LoginUser SessionUser user
    ) {
        return likeService.like(postId, user.getEmail());
    }
    
    @DeleteMapping("/{post_id}")
    public LikeResponse likeCancel(
        @PathVariable("post_id") Long postId,
        @LoginUser SessionUser user
    ) {
        return likeService.likeCancel(postId, user.getEmail());
    }
}
