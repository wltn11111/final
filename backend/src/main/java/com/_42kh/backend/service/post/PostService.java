package com._42kh.backend.service.post;

import com._42kh.backend.domain.post.Post;
import com._42kh.backend.domain.post.PostRepository;
import com._42kh.backend.web.post.dto.PostRequest;
import com._42kh.backend.web.post.dto.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long save(PostRequest postRequest) {
        return postRepository.save(postRequest.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public PostResponse findById(Long id) {
        Post post = postRepository.findById(id).orElseThrow();
        return new PostResponse(post);
    }

    @Transactional
    public Long update(Long id, PostRequest postRequest) {
        Post post = postRepository.findById(id).orElseThrow();
        post.update(postRequest.getTitle(), postRequest.getContents());
        return id;
    }

    @Transactional
    public Long delete(Long id) {
        Post post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);
        return id;
    }
}
