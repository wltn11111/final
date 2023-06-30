package com._42kh.backend.domain.post;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category {
    
    FREEDOM("자유"),
    IT("IT"),
    SPORTS("운동"),
    FASHION("패션");
    
    private final String title;
}
