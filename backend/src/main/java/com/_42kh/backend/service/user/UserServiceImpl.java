package com._42kh.backend.service.user;

import com._42kh.backend.config.auth.dto.SessionUser;
import com._42kh.backend.domain.user.User;
import com._42kh.backend.domain.user.UserRepository;
import com._42kh.backend.web.user.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserResponse getUser(SessionUser sessionUser) {
        User user = userRepository.findById(sessionUser.getUserId()).orElseThrow();

        return new UserResponse(user);
    }

    @Override
    @Transactional
    public void deleteUser(SessionUser sessionUser) {
        User user = userRepository.findById(sessionUser.getUserId()).orElseThrow();

        userRepository.delete(user);
    }
}
