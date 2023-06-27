package com._42kh.backend.service.post;

import com._42kh.backend.web.post.dto.PostRequest;
import com._42kh.backend.web.post.dto.PostResponse;
import com._42kh.backend.web.post.dto.PostSaveResponse;
import com._42kh.backend.web.post.dto.PostUpdateResponse;

import java.util.List;

public interface PostService {

    PostSaveResponse save(PostRequest postRequest);

    PostResponse findById(Long id);

    List<PostResponse> findAll();

    PostUpdateResponse update(Long id, PostRequest postRequest);

    void delete(Long id);
}
