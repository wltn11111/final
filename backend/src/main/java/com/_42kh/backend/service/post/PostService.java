package com._42kh.backend.service.post;

import com._42kh.backend.config.auth.dto.SessionUser;
import com._42kh.backend.web.post.dto.PostRequest;
import com._42kh.backend.web.post.dto.PostResponse;
import com._42kh.backend.web.post.dto.PostSaveResponse;
import com._42kh.backend.web.post.dto.PostUpdateResponse;

import java.util.List;

public interface PostService {

    PostSaveResponse save(PostRequest postRequest, SessionUser sessionUser);

    PostResponse findById(Long postId);

    List<PostResponse> findAll();

    PostUpdateResponse update(Long postId, PostRequest postRequest, SessionUser sessionUser);

    void delete(Long postId, SessionUser sessionUser);
}
