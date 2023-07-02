package com._42kh.backend.service.mypage;

import com._42kh.backend.config.auth.dto.SessionUser;
import com._42kh.backend.web.mypage.dto.MyPageBookmarkResponse;
import com._42kh.backend.web.mypage.dto.MyPageCommentResponse;
import com._42kh.backend.web.mypage.dto.MyPagePostResponse;

import java.util.List;

public interface MyPageService {

    List<MyPagePostResponse> findPosts(SessionUser sessionUser);

    List<MyPageCommentResponse> findComments(SessionUser sessionUser);

    List<MyPageBookmarkResponse> findBookmarks(SessionUser sessionUser);
}
