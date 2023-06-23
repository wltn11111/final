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

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReplyServiceImpl implements ReplyService {

    private final PostRepository postRepository;
	private final ReplyRepository replyRepository;
	
	@Override
	@Transactional
	public Long save(Long postId, ReplyRequest replyRequest) {
		Post post = postRepository.findById(postId).orElseThrow();
		return replyRepository.save(replyRequest.toEntity(post)).getId();
	}
	
	@Override
	@Transactional(readOnly = true)
    public List<ReplyResponse> findAll() {
        List<Reply> replies = replyRepository.findAll();
        return replies.stream()
            .map(ReplyResponse::new)
            .toList();
    }

	@Override
	@Transactional
	public Long update(Long id, ReplyRequest replyRequest) {
		Reply reply = replyRepository.findById(id).orElseThrow();
		reply.update(replyRequest.getContents());
		return id;
	} 

	@Override
	@Transactional
	public Long delete(Long id) {
		Reply reply = replyRepository.findById(id).orElseThrow();
		replyRepository.delete(reply);
		return id;
	}
}