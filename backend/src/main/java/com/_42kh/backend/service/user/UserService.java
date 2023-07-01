package com._42kh.backend.service.user;

import com._42kh.backend.web.user.dto.UserResponse;

public interface UserService {

    UserResponse findById(Long userId);
}
