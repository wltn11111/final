package com._42kh.backend.service.bookmark;

import com._42kh.backend.config.auth.dto.SessionUser;
import com._42kh.backend.web.bookmark.dto.BookmarkResponse;
import com._42kh.backend.web.bookmark.dto.BookmarkWithIdResponse;

import java.util.List;

public interface BookmarkService {

    BookmarkResponse findByPostId(Long postId, SessionUser sessionUser);

    List<BookmarkWithIdResponse> findAll(SessionUser sessionUser);

    BookmarkResponse subscribe(Long postId, SessionUser sessionUser);

    BookmarkResponse unsubscribe(Long postId, SessionUser sessionUser);
}