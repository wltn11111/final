package com._42kh.backend.web.bookmark;

import com._42kh.backend.config.auth.LoginUser;
import com._42kh.backend.config.auth.dto.SessionUser;
import com._42kh.backend.service.bookmark.BookmarkService;
import com._42kh.backend.web.bookmark.dto.BookmarkResponse;
import com._42kh.backend.web.bookmark.dto.BookmarkWithIdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/bookmark")
public class BookmarkController {

    private final BookmarkService bookmarkService;

    @GetMapping("/{post_id}")
    public BookmarkResponse findByPostId(
        @PathVariable("post_id") Long postId,
        @LoginUser SessionUser sessionUser
    ) {
        return bookmarkService.findByPostId(postId, sessionUser);
    }

    @GetMapping
    public List<BookmarkWithIdResponse> findAll(@LoginUser SessionUser sessionUser) {
        return bookmarkService.findAll(sessionUser);
    }

    @PostMapping("/{post_id}")
    public BookmarkResponse subscribe(
        @PathVariable("post_id") Long postId,
        @LoginUser SessionUser sessionUser
    ) {
        return bookmarkService.subscribe(postId, sessionUser);
    }

    @DeleteMapping("/{post_id}")
    public void unsubscribe(
        @PathVariable("post_id") Long postId,
        @LoginUser SessionUser sessionUser
    ) {
        bookmarkService.unsubscribe(postId, sessionUser);
    }
}
