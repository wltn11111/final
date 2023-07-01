package com._42kh.backend.web.like;

import com._42kh.backend.config.auth.LoginUser;
import com._42kh.backend.config.auth.dto.SessionUser;
import com._42kh.backend.service.like.PostLikeService;
import com._42kh.backend.web.like.dto.PostLikeResponse;
import com._42kh.backend.web.like.dto.PostLikeWithIdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/likes/posts")
public class PostLikeController {

    private final PostLikeService postLikeService;

    @GetMapping("/{post_id}")
    public PostLikeResponse findByPostId(
        @PathVariable("post_id") Long postId,
        @LoginUser SessionUser sessionUser
    ) {
        return postLikeService.findByPostId(postId, sessionUser);
    }

    @GetMapping
    public List<PostLikeWithIdResponse> findAll(@LoginUser SessionUser sessionUser) {
        return postLikeService.findAll(sessionUser);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{post_id}")
    public PostLikeResponse like(
        @PathVariable("post_id") Long postId,
        @LoginUser SessionUser sessionUser
    ) {
        return postLikeService.addLike(postId, sessionUser);
    }

    @DeleteMapping("/{post_id}")
    public PostLikeResponse likeCancel(
        @PathVariable("post_id") Long postId,
        @LoginUser SessionUser sessionUser
    ) {
        return postLikeService.removeLike(postId, sessionUser);
    }
}
