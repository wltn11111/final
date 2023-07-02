package com._42kh.backend.web.mypage.dto;

import com._42kh.backend.domain.bookmark.Bookmark;
import lombok.Getter;

@Getter
public class MyPageBookmarkResponse {

    private final Long postId;
    private final String title;

    public MyPageBookmarkResponse(Bookmark bookmark) {
        postId = bookmark.getBookmarkId().getPost().getId();
        title = bookmark.getBookmarkId().getPost().getTitle();
    }
}
