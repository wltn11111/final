package com._42kh.backend.service.like;

import com._42kh.backend.config.auth.dto.SessionUser;
import com._42kh.backend.domain.comment.Comment;
import com._42kh.backend.domain.comment.CommentRepository;
import com._42kh.backend.domain.like.CommentLike;
import com._42kh.backend.domain.like.CommentLikeRepository;
import com._42kh.backend.domain.user.User;
import com._42kh.backend.domain.user.UserRepository;
import com._42kh.backend.web.like.dto.CommentLikeResponse;
import com._42kh.backend.web.like.dto.CommentLikeWithIdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentLikeServiceImpl implements CommentLikeService {

    private final CommentLikeRepository commentLikeRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    @Override
    public List<CommentLikeWithIdResponse> findAllByPostId(
        Long postId,
        SessionUser sessionUser
    ) {
        return commentRepository.findByPostId(postId)
            .stream()
            .map(c -> {
                Boolean isLiked = Optional.ofNullable(sessionUser)
                    .map(su -> commentLikeRepository
                        .existsByCommentLikeIdCommentIdAndCommentLikeIdUserId(c.getId(), su.getUserId()))
                    .orElse(Boolean.FALSE);
                Long count = commentLikeRepository.countByCommentLikeIdCommentId(c.getId());

                return new CommentLikeWithIdResponse(c.getId(), isLiked, count);
            })
            .toList();
    }

    @Override
    @Transactional
    public CommentLikeResponse addLike(
        Long commentId,
        SessionUser sessionUser
    ) {
        User user = userRepository.findById(sessionUser.getUserId()).orElseThrow();
        Comment comment = commentRepository.findById(commentId).orElseThrow();

        commentLikeRepository.save(new CommentLike(comment, user));

        Long count = commentLikeRepository.countByCommentLikeIdCommentId(commentId);
        return new CommentLikeResponse(true, count);
    }

    @Override
    @Transactional
    public CommentLikeResponse removeLike(
        Long commentId,
        SessionUser sessionUser
    ) {
        User user = userRepository.findById(sessionUser.getUserId()).orElseThrow();
        Comment comment = commentRepository.findById(commentId).orElseThrow();

        CommentLike commentLike = commentLikeRepository
            .findByCommentLikeIdCommentIdAndCommentLikeIdUserId(comment.getId(), user.getId()).orElseThrow();

        commentLikeRepository.delete(commentLike);
        Long count = commentLikeRepository.countByCommentLikeIdCommentId(commentId);
        return new CommentLikeResponse(false, count);
    }
}