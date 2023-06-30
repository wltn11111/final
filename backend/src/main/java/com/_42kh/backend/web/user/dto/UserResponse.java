package com._42kh.backend.web.user.dto;

import com._42kh.backend.config.auth.dto.SessionUser;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponse {

    private final String name;
    private final String email;
    private final String picture;
    private final String vendor;
    private final LocalDateTime createdDate;

    public UserResponse(SessionUser user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
        this.vendor = user.getVendor();
        this.createdDate = user.getCreatedDate();
    }
}
