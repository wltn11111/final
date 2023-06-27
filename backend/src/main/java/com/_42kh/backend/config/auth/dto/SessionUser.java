package com._42kh.backend.config.auth.dto;

import com._42kh.backend.domain.user.User;
import lombok.Getter;

@Getter
public class SessionUser {

    private final String name;
    private final String email;
    private final String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
