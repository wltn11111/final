package com._42kh.backend.domain.user;

import com._42kh.backend.domain.BaseTime;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "users")
public class User extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String nickname;

    private String picture;

    @Column(updatable = false)
    private String vendor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(
        String email,
        String nickname,
        String picture,
        String vendor,
        Role role
    ) {
        this.email = email;
        this.nickname = nickname;
        this.picture = picture;
        this.vendor = vendor;
        this.role = role;
    }

    public User update(
        String nickname,
        String picture
    ) {
        this.nickname = nickname;
        this.picture = picture;
        return this;
    }

    public String getRoleKey() {
        return role.getKey();
    }
}
