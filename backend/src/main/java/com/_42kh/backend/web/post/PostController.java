package com._42kh.backend.web.post;

import com._42kh.backend.service.post.PostService;
import com._42kh.backend.web.post.dto.PostRequest;
import com._42kh.backend.web.post.dto.PostResponse;
import com._42kh.backend.web.post.dto.PostSaveResponse;
import com._42kh.backend.web.post.dto.PostUpdateResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostService postService;

    @PostMapping
    public PostSaveResponse save(@RequestBody PostRequest postRequest) {
        return postService.save(postRequest);
    }

    @GetMapping("/{id}")
    public PostResponse findById(@PathVariable("id") Long id) {
        return postService.findById(id);
    }

    @GetMapping
    public List<PostResponse> findAll() {
        return postService.findAll();
    }

    @PutMapping("/{id}")
    public PostUpdateResponse update(@PathVariable("id") Long id, @RequestBody PostRequest postRequest) {
        return postService.update(id, postRequest);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable("id") Long id) {
        return postService.delete(id);
    }
}
