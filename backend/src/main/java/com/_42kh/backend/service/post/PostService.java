package com._42kh.backend.service.post;

import com._42kh.backend.web.post.dto.PostRequest;
import com._42kh.backend.web.post.dto.PostResponse;

import java.util.List;

public interface PostService {

    Long save(PostRequest postRequest);

    PostResponse findById(Long id);

    List<PostResponse> findAll();

    Long update(Long id, PostRequest postRequest);

    Long delete(Long id);
}
