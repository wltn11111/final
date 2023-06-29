package com._42kh.backend.service.like;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com._42kh.backend.domain.like.PostLikeRepository;
import com._42kh.backend.domain.post.Post;
import com._42kh.backend.domain.post.PostRepository;
import com._42kh.backend.domain.user.User;
import com._42kh.backend.domain.user.UserRepository;
import com._42kh.backend.web.like.dto.PostLikeResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostLikeServiceImpl implements PostLikeService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final PostLikeRepository postLikeRepository;

    @Override
    @Transactional(readOnly = true)
    public PostLikeResponse findByPostId(Long postId, String userEmail) {
        Long count = postLikeRepository.countByPostLikeIdPostId(postId);
        Boolean isLike = postLikeRepository.existsByPostLikeIdUserEmail(userEmail);

        return new PostLikeResponse(postId, count, isLike);
    }

    @Override
    @Transactional
    public PostLikeResponse like(Long postId, String userEmail) {
        Post post = postRepository.findById(postId).orElseThrow();
        User user = userRepository.findByEmail(userEmail).orElseThrow();

        postLikeRepository.save(user.like(post));
        Long count = postLikeRepository.countByPostLikeIdPostId(postId);

        return new PostLikeResponse(postId, count, true);
    }

    @Override
    @Transactional
    public PostLikeResponse likeCancel(Long postId, String userEmail) {
        Post post = postRepository.findById(postId).orElseThrow();
        User user = userRepository.findByEmail(userEmail).orElseThrow();

        postLikeRepository.delete(user.like(post));
        Long count = postLikeRepository.countByPostLikeIdPostId(postId);

        return new PostLikeResponse(postId, count, false);
    }
}
