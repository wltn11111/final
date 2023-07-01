package com._42kh.backend.config.auth.dto;

import com._42kh.backend.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {

    private final Long userId;

    public SessionUser(User user) {
        userId = user.getId();
    }
}
