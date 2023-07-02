package com._42kh.backend.service.mypage;

import com._42kh.backend.config.auth.dto.SessionUser;
import com._42kh.backend.domain.bookmark.Bookmark;
import com._42kh.backend.domain.bookmark.BookmarkRepository;
import com._42kh.backend.domain.comment.Comment;
import com._42kh.backend.domain.comment.CommentRepository;
import com._42kh.backend.domain.post.Post;
import com._42kh.backend.domain.post.PostRepository;
import com._42kh.backend.domain.user.User;
import com._42kh.backend.domain.user.UserRepository;
import com._42kh.backend.web.mypage.dto.MyPageBookmarkResponse;
import com._42kh.backend.web.mypage.dto.MyPageCommentResponse;
import com._42kh.backend.web.mypage.dto.MyPagePostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MyPageServiceImpl implements MyPageService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final BookmarkRepository bookmarkRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public List<MyPagePostResponse> findPosts(SessionUser sessionUser) {
        User user = userRepository.findById(sessionUser.getUserId()).orElseThrow();
        List<Post> posts = postRepository.findByUserId(
            user.getId(),
            Sort.by(Sort.Direction.DESC, "createdDate")
        );

        return posts.stream()
            .map(MyPagePostResponse::new)
            .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<MyPageCommentResponse> findComments(SessionUser sessionUser) {
        User user = userRepository.findById(sessionUser.getUserId()).orElseThrow();
        List<Comment> comments = commentRepository.findByUserId(
            user.getId(),
            Sort.by(Sort.Direction.DESC, "createdDate")
        );

        return comments.stream()
            .map(MyPageCommentResponse::new)
            .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<MyPageBookmarkResponse> findBookmarks(SessionUser sessionUser) {
        User user = userRepository.findById(sessionUser.getUserId()).orElseThrow();
        List<Bookmark> bookmarks = bookmarkRepository.findByBookmarkIdUserId(
            user.getId(),
            Sort.by(Sort.Direction.DESC, "createdDate")
        );

        return bookmarks.stream()
            .map(MyPageBookmarkResponse::new)
            .toList();
    }
}