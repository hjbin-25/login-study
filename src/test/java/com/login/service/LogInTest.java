package com.login.service;

import com.login.jwt.JwtUtil;
import com.login.repository.CustomUserRepository;
import com.login.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.Mockito.mock;

public class LogInTest {

    private AuthService authService;

    private UserRepository userRepository = mock(UserRepository.class);
    private PasswordEncoder passwordEncoder = mock(PasswordEncoder.class);
    private JwtUtil jwtUtil = mock(JwtUtil.class);

    @BeforeEach
    public void setUp() {
        authService = new AuthService(userRepository, passwordEncoder, jwtUtil);
    }

    @Test
    public void testLogin() {

    }

}
