package com._42kh.backend.web.user.dto;

import com._42kh.backend.domain.user.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponse {

    private final String email;
    private final String nickname;
    private final String picture;
    private final String vendor;
    private final LocalDateTime createdDate;

    public UserResponse(User user) {
        this.email = user.getEmail();
        this.nickname = user.getNickname();
        this.picture = user.getPicture();
        this.vendor = user.getVendor();
        this.createdDate = user.getCreatedDate();
    }
}
