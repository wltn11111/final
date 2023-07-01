package com._42kh.backend.service.comment;

import com._42kh.backend.config.auth.dto.SessionUser;
import com._42kh.backend.domain.comment.Comment;
import com._42kh.backend.domain.comment.CommentRepository;
import com._42kh.backend.domain.post.Post;
import com._42kh.backend.domain.post.PostRepository;
import com._42kh.backend.domain.user.User;
import com._42kh.backend.domain.user.UserRepository;
import com._42kh.backend.web.comment.dto.CommentRequest;
import com._42kh.backend.web.comment.dto.CommentResponse;
import com._42kh.backend.web.comment.dto.CommentSaveResponse;
import com._42kh.backend.web.comment.dto.CommentUpdateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

	@Override
	@Transactional
	public CommentSaveResponse save(
        Long postId,
        CommentRequest commentRequest,
        SessionUser sessionUser
    ) {
        User user = userRepository.findById(sessionUser.getUserId()).orElseThrow();
        Post post = postRepository.findById(postId).orElseThrow();

        Comment comment = commentRequest.toEntity()
            .setPost(post)
            .setUser(user);

        commentRepository.save(comment);
        return new CommentSaveResponse(comment);
	}

    @Override
    @Transactional(readOnly = true)
    public List<CommentResponse> findByPostId(Long postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);

        return comments.stream()
            .map(CommentResponse::new)
            .toList();
    }

	@Override
	@Transactional
	public CommentUpdateResponse update(
        Long commentId,
        CommentRequest commentRequest,
        SessionUser sessionUser
    ) {
        User user = userRepository.findById(sessionUser.getUserId()).orElseThrow();
        Comment comment = commentRepository.findById(commentId).orElseThrow();

        comment.validateUser(user)
            .setContents(commentRequest.getContents());

        commentRepository.save(comment);
		return new CommentUpdateResponse(comment);
	}

	@Override
	@Transactional
	public void delete(
        Long commentId,
        SessionUser sessionUser
    ) {
        User user = userRepository.findById(sessionUser.getUserId()).orElseThrow();
        Comment comment = commentRepository.findById(commentId).orElseThrow();

        comment.validateUser(user);

        commentRepository.delete(comment);
	}
}