package com._42kh.backend.service.reply;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com._42kh.backend.domain.post.Post;
import com._42kh.backend.domain.post.PostRepository;
import com._42kh.backend.domain.reply.Reply;
import com._42kh.backend.domain.reply.ReplyRepository;
import com._42kh.backend.web.reply.dto.ReplyRequest;
import com._42kh.backend.web.reply.dto.ReplyResponse;
import com._42kh.backend.web.reply.dto.ReplySaveResponse;
import com._42kh.backend.web.reply.dto.ReplyUpdateResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReplyServiceImpl implements ReplyService {

    private final PostRepository postRepository;
	private final ReplyRepository replyRepository;

	@Override
	@Transactional
	public ReplySaveResponse save(Long postId, ReplyRequest replyRequest) {
		Post post = postRepository.findById(postId).orElseThrow();
		Reply reply = replyRepository.save(replyRequest.toEntity(post));
		return new ReplySaveResponse(reply);
	}

    @Override
    @Transactional(readOnly = true)
    public List<ReplyResponse> findByPostId(Long postId) {
        List<Reply> replies = replyRepository.findByPostId(postId);
        return replies.stream()
            .map(ReplyResponse::new)
            .toList();
    }

	@Override
	@Transactional
	public ReplyUpdateResponse update(Long id, ReplyRequest replyRequest) {
		Reply reply = replyRepository.findById(id).orElseThrow();
		reply.update(replyRequest.getContents());
		return new ReplyUpdateResponse(reply);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		Reply reply = replyRepository.findById(id).orElseThrow();
		replyRepository.delete(reply);
	}
}