package com._42kh.backend.service.user;

import com._42kh.backend.config.auth.dto.SessionUser;
import com._42kh.backend.web.user.dto.UserResponse;

public interface UserService {

    UserResponse getUser(SessionUser sessionUser);

    void deleteUser(SessionUser sessionUser);
}
