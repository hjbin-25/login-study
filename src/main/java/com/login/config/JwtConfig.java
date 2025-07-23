package com.login.config;

import com.login.jwt.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

    private final String SECRET_KEY = "#include-<iostream>-using-namespace-std;";
    private final long EXPIRATION_MS = 1000 * 60 * 60 * 24;

    @Bean
    public JwtUtil jwtUtil() {

        return new JwtUtil(SECRET_KEY, EXPIRATION_MS);
    }
}
