package com._42kh.backend.service.bookmark;

import com._42kh.backend.config.auth.dto.SessionUser;
import com._42kh.backend.domain.bookmark.Bookmark;
import com._42kh.backend.domain.bookmark.BookmarkRepository;
import com._42kh.backend.domain.post.Post;
import com._42kh.backend.domain.post.PostRepository;
import com._42kh.backend.domain.user.User;
import com._42kh.backend.domain.user.UserRepository;
import com._42kh.backend.web.bookmark.dto.BookmarkResponse;
import com._42kh.backend.web.bookmark.dto.BookmarkWithIdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BookmarkServiceImpl implements BookmarkService {

    private final BookmarkRepository bookmarkRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Override
    @Transactional(readOnly = true)
    public BookmarkResponse findByPostId(
        Long postId,
        SessionUser sessionUser
    ) {
        Boolean isSubscribed = Optional.ofNullable(sessionUser)
            .map(su -> bookmarkRepository
                .existsByBookmarkIdPostIdAndBookmarkIdUserId(postId, su.getUserId()))
            .orElse(Boolean.FALSE);

        return new BookmarkResponse(isSubscribed);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BookmarkWithIdResponse> findAll(SessionUser sessionUser) {
        return postRepository.findAll()
            .stream()
            .map(p -> {
                Boolean isSubscribed = Optional.ofNullable(sessionUser)
                    .map(su -> bookmarkRepository
                        .existsByBookmarkIdPostIdAndBookmarkIdUserId(p.getId(), su.getUserId()))
                    .orElse(Boolean.FALSE);

                return new BookmarkWithIdResponse(p.getId(), isSubscribed);
            })
            .toList();
    }

    @Override
    @Transactional
    public BookmarkResponse subscribe(
        Long postId,
        SessionUser sessionUser
    ) {
        User user = userRepository.findById(sessionUser.getUserId()).orElseThrow();
        Post post = postRepository.findById(postId).orElseThrow();

        bookmarkRepository.save(new Bookmark(post, user));

        return new BookmarkResponse(true);
    }

    @Override
    @Transactional
    public BookmarkResponse unsubscribe(
        Long postId,
        SessionUser sessionUser
    ) {
        User user = userRepository.findById(sessionUser.getUserId()).orElseThrow();
        Post post = postRepository.findById(postId).orElseThrow();

        Bookmark bookmark = bookmarkRepository
            .findByBookmarkIdPostIdAndBookmarkIdUserId(post.getId(), user.getId()).orElseThrow();

        bookmarkRepository.delete(bookmark);
        return new BookmarkResponse(false);
    }
}