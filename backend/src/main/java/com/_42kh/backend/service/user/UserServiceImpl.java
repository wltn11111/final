package com._42kh.backend.service.user;

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
    public UserResponse findById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();

        return new UserResponse(user);
    }
}
