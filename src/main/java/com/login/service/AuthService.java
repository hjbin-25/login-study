package com.login.service;

import com.login.domain.User;
import com.login.dto.LoginRequest;
import com.login.dto.SignupRequest;
import com.login.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void signUp(SignupRequest Request) {

    }

    public String login(LoginRequest request) {
        return null;
    }
}
