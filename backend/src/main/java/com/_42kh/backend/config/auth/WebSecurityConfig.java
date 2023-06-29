package com._42kh.backend.config.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@PropertySource("classpath:value.properties")
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Value("${defaultSuccessUrl}")
    private String defaultSuccessUrl;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .csrf(AbstractHttpConfigurer::disable)
            .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
            .authorizeHttpRequests(requests -> requests
                .requestMatchers("/**").permitAll()
            )
            .sessionManagement(sessionManager -> sessionManager
                .invalidSessionUrl("/login?invalid=true")
                .sessionFixation()
                .migrateSession()
                .maximumSessions(1)
                .expiredUrl("/login?expired=true")
            )
            .oauth2Login(oauth2LoginCustomizer -> oauth2LoginCustomizer
                .userInfoEndpoint(config -> config.userService(customOAuth2UserService))
                .defaultSuccessUrl(defaultSuccessUrl)
            )
            .logout(logoutCustomizer -> logoutCustomizer.logoutSuccessUrl(defaultSuccessUrl))
            .build();
    }
}
