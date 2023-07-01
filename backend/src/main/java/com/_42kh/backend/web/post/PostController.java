package com._42kh.backend.web.post;

import com._42kh.backend.config.auth.LoginUser;
import com._42kh.backend.config.auth.dto.SessionUser;
import com._42kh.backend.service.post.PostService;
import com._42kh.backend.web.post.dto.PostRequest;
import com._42kh.backend.web.post.dto.PostResponse;
import com._42kh.backend.web.post.dto.PostSaveResponse;
import com._42kh.backend.web.post.dto.PostUpdateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostService postService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public PostSaveResponse save(
        @RequestBody PostRequest postRequest,
        @LoginUser SessionUser sessionUser
    ) {
        return postService.save(postRequest, sessionUser);
    }

    @GetMapping("/{post_id}")
    public PostResponse findById(@PathVariable("post_id") Long postId) {
        return postService.findById(postId);
    }

    @GetMapping
    public List<PostResponse> findAll() {
        return postService.findAll();
    }

    @PutMapping("/{post_id}")
    public PostUpdateResponse update(
        @PathVariable("post_id") Long postId,
        @RequestBody PostRequest postRequest,
        @LoginUser SessionUser sessionUser
    ) {
        return postService.update(postId, postRequest, sessionUser);
    }

    @DeleteMapping("/{postId}")
    public void delete(
        @PathVariable("postId") Long postId,
        @LoginUser SessionUser sessionUser
    ) {
        postService.delete(postId, sessionUser);
    }
}
