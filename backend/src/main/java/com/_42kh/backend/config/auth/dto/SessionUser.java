package com._42kh.backend.config.auth.dto;

import com._42kh.backend.domain.user.User;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
public class SessionUser implements Serializable {

    private final String name;
    private final String email;
    private final String picture;
    private final String vendor;
    private final LocalDateTime createdDate;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
        this.vendor = user.getVendor();
        this.createdDate = user.getCreatedDate();
    }
}
