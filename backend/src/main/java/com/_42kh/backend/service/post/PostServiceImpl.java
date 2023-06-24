package com._42kh.backend.service.post;

import com._42kh.backend.domain.post.Post;
import com._42kh.backend.domain.post.PostRepository;
import com._42kh.backend.web.post.dto.PostRequest;
import com._42kh.backend.web.post.dto.PostResponse;
import com._42kh.backend.web.post.dto.PostSaveResponse;
import com._42kh.backend.web.post.dto.PostUpdateResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    @Transactional
    public PostSaveResponse save(PostRequest postRequest) {
        Post post = postRepository.save(postRequest.toEntity());
        return new PostSaveResponse(post);
    }

    @Override
    @Transactional(readOnly = true)
    public PostResponse findById(Long id) {
        Post post = postRepository.findById(id).orElseThrow();
        return new PostResponse(post);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PostResponse> findAll() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
            .map(PostResponse::new)
            .toList();
    }

    @Override
    @Transactional
    public PostUpdateResponse update(Long id, PostRequest postRequest) {
        Post post = postRepository.findById(id).orElseThrow();
        post.update(postRequest.getTitle(), postRequest.getContents());
        return new PostUpdateResponse(post);
    }

    @Override
    @Transactional
    public Long delete(Long id) {
        Post post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);
        return id;
    }
}
