package com._42kh.backend.config.auth.dto;

import com._42kh.backend.domain.user.Role;
import com._42kh.backend.domain.user.User;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {

    private final Map<String, Object> attributes;
    private final String nameAttributeKey;
    private final String nickname;
    private final String email;
    private final String picture;
    private final String vendor;

    @Builder
    public OAuthAttributes(
        Map<String, Object> attributes,
        String nameAttributeKey,
        String nickname,
        String email,
        String picture,
        String vendor
    ) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.nickname = nickname;
        this.email = email;
        this.picture = picture;
        this.vendor = vendor;
    }

    public static OAuthAttributes of(
        String registrationId,
        String userNameAttributeName,
        Map<String, Object> attributes
    ) {
        if ("naver".equals(registrationId)) {
            return ofNaver("id", attributes);
        }
        return ofGoogle(userNameAttributeName, attributes);
    }

    private static OAuthAttributes ofGoogle(
        String userNameAttributeName,
        Map<String, Object> attributes
    ) {
        return OAuthAttributes.builder()
            .nickname((String) attributes.get("name"))
            .email((String) attributes.get("email"))
            .picture((String) attributes.get("picture"))
            .vendor("google")
            .attributes(attributes)
            .nameAttributeKey(userNameAttributeName)
            .build();
    }

    private static OAuthAttributes ofNaver(
        String userNameAttributeName,
        Map<String, Object> attributes
    ) {
        Map<String, Object> response = (Map<String, Object>) attributes.get("response");

        return OAuthAttributes.builder()
            .nickname((String) response.get("name"))
            .email((String) response.get("email"))
            .picture((String) response.get("profile_image"))
            .vendor("naver")
            .attributes(response)
            .nameAttributeKey(userNameAttributeName)
            .build();
    }

    public User toEntity() {
        return User.builder()
            .nickname(nickname)
            .email(email)
            .picture(picture)
            .vendor(vendor)
            .role(Role.GUEST)
            .build();
    }
}
