package com._42kh.backend.service.comment;

import java.util.List;

import com._42kh.backend.domain.comment.Comment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com._42kh.backend.domain.post.Post;
import com._42kh.backend.domain.post.PostRepository;
import com._42kh.backend.domain.comment.CommentRepository;
import com._42kh.backend.web.comment.dto.CommentRequest;
import com._42kh.backend.web.comment.dto.CommentResponse;
import com._42kh.backend.web.comment.dto.CommentSaveResponse;
import com._42kh.backend.web.comment.dto.CommentUpdateResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {

    private final PostRepository postRepository;
	private final CommentRepository commentRepository;

	@Override
	@Transactional
	public CommentSaveResponse save(Long postId, CommentRequest commentRequest) {
		Post post = postRepository.findById(postId).orElseThrow();
		Comment comment = commentRepository.save(commentRequest.toEntity(post));
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
	public CommentUpdateResponse update(Long id, CommentRequest commentRequest) {
		Comment comment = commentRepository.findById(id).orElseThrow();
		comment.update(commentRequest.getContents());
		return new CommentUpdateResponse(comment);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		Comment comment = commentRepository.findById(id).orElseThrow();
		commentRepository.delete(comment);
	}
}