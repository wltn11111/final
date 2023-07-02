package com._42kh.backend.config;

import com._42kh.backend.config.auth.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpMethod;
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

    @Value("${defaultLoginSuccessUrl}")
    private String defaultLoginSuccessUrl;

    @Value("${defaultLogoutSuccessUrl}")
    private String defaultLogoutSuccessUrl;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .csrf(AbstractHttpConfigurer::disable)
            .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
            .authorizeHttpRequests(requests -> requests
                .requestMatchers("/api/v1/users").authenticated()
                .requestMatchers("/api/v1/my_page").authenticated()
                .requestMatchers(HttpMethod.POST, "/api/v1/**").authenticated()
                .requestMatchers(HttpMethod.PUT, "/api/v1/**").authenticated()
                .requestMatchers(HttpMethod.DELETE, "/api/v1/**").authenticated()
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
                .defaultSuccessUrl(defaultLoginSuccessUrl)
            )
            .logout(logoutCustomizer -> logoutCustomizer.logoutSuccessUrl(defaultLogoutSuccessUrl))
            .build();
    }
}
