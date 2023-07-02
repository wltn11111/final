package com._42kh.backend.web.mypage;

import com._42kh.backend.config.auth.LoginUser;
import com._42kh.backend.config.auth.dto.SessionUser;
import com._42kh.backend.service.mypage.MyPageService;
import com._42kh.backend.web.mypage.dto.MyPageBookmarkResponse;
import com._42kh.backend.web.mypage.dto.MyPageCommentResponse;
import com._42kh.backend.web.mypage.dto.MyPagePostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/my_page")
public class MyPageController {

    private final MyPageService myPageService;

    @GetMapping("/posts")
    public List<MyPagePostResponse> getMyPosts(@LoginUser SessionUser sessionUser) {
        return myPageService.findPosts(sessionUser);
    }

    @GetMapping("/comments")
    public List<MyPageCommentResponse> getMyComments(@LoginUser SessionUser sessionUser) {
        return myPageService.findComments(sessionUser);
    }

    @GetMapping("/bookmarks")
    public List<MyPageBookmarkResponse> getMyBookmarks(@LoginUser SessionUser sessionUser) {
        return myPageService.findBookmarks(sessionUser);
    }
}
