package com._42kh.backend.service.like;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com._42kh.backend.domain.like.LikeRepository;
import com._42kh.backend.domain.post.Post;
import com._42kh.backend.domain.post.PostRepository;
import com._42kh.backend.domain.user.User;
import com._42kh.backend.domain.user.UserRepository;
import com._42kh.backend.web.like.dto.LikeResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class LikeServiceImpl implements LikeService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final LikeRepository likeRepository;
    
    @Override
    @Transactional(readOnly = true)
    public LikeResponse findByPostId(Long postId, String userEmail) {
        Long count = likeRepository.countByLikeIdPostId(postId);
        Boolean isLike = likeRepository.existsByLikeIdUserEmail(userEmail);
        
        return new LikeResponse(postId, count, isLike);
    }

    @Override
    @Transactional
    public LikeResponse like(Long postId, String userEmail) {
        Post post = postRepository.findById(postId).orElseThrow();
        User user = userRepository.findByEmail(userEmail).orElseThrow();
        
        likeRepository.save(user.like(post));
        Long count = likeRepository.countByLikeIdPostId(postId);
        
        return new LikeResponse(postId, count, true);
    }

    @Override
    @Transactional
    public LikeResponse likeCancel(Long postId, String userEmail) {
        Post post = postRepository.findById(postId).orElseThrow();
        User user = userRepository.findByEmail(userEmail).orElseThrow();
        
        likeRepository.delete(user.like(post));
        Long count = likeRepository.countByLikeIdPostId(postId);
        
        return new LikeResponse(postId, count, false);
    }
}
