package com._42kh.backend.service.like;

import com._42kh.backend.config.auth.dto.SessionUser;
import com._42kh.backend.domain.like.PostLike;
import com._42kh.backend.domain.like.PostLikeRepository;
import com._42kh.backend.domain.post.Post;
import com._42kh.backend.domain.post.PostRepository;
import com._42kh.backend.domain.user.User;
import com._42kh.backend.domain.user.UserRepository;
import com._42kh.backend.web.like.dto.PostLikeResponse;
import com._42kh.backend.web.like.dto.PostLikeWithIdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostLikeServiceImpl implements PostLikeService {

    private final PostLikeRepository postLikeRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Override
    @Transactional(readOnly = true)
    public PostLikeResponse findByPostId(
        Long postId,
        SessionUser sessionUser
    ) {
        Boolean isLiked = Optional.ofNullable(sessionUser)
            .map(su -> postLikeRepository
                .existsByPostLikeIdPostIdAndPostLikeIdUserId(postId, su.getUserId()))
            .orElse(Boolean.FALSE);
        Long count = postLikeRepository.countByPostLikeIdPostId(postId);

        return new PostLikeResponse(isLiked, count);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PostLikeWithIdResponse> findAll(SessionUser sessionUser) {
        return postRepository.findAll()
            .stream()
            .map(p -> {
                Boolean isLiked = Optional.ofNullable(sessionUser)
                    .map(su -> postLikeRepository
                        .existsByPostLikeIdPostIdAndPostLikeIdUserId(p.getId(), su.getUserId()))
                    .orElse(Boolean.FALSE);
                Long count = postLikeRepository.countByPostLikeIdPostId(p.getId());

                return new PostLikeWithIdResponse(p.getId(), isLiked, count);
            })
            .toList();
    }

    @Override
    @Transactional
    public PostLikeResponse addLike(
        Long postId,
        SessionUser sessionUser
    ) {
        User user = userRepository.findById(sessionUser.getUserId()).orElseThrow();
        Post post = postRepository.findById(postId).orElseThrow();

        postLikeRepository.save(new PostLike(post, user));

        Long count = postLikeRepository.countByPostLikeIdPostId(postId);
        return new PostLikeResponse(true, count);
    }

    @Override
    @Transactional
    public PostLikeResponse removeLike(
        Long postId,
        SessionUser sessionUser
    ) {
        User user = userRepository.findById(sessionUser.getUserId()).orElseThrow();
        Post post = postRepository.findById(postId).orElseThrow();

        PostLike postLike = postLikeRepository
            .findByPostLikeIdPostIdAndPostLikeIdUserId(post.getId(), user.getId()).orElseThrow();

        postLikeRepository.delete(postLike);
        Long count = postLikeRepository.countByPostLikeIdPostId(postId);
        return new PostLikeResponse(false, count);
    }
}
