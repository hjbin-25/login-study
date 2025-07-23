package com.login.service;

import com.login.domain.User;
import com.login.dto.LoginRequest;
import com.login.dto.SignupRequest;
import com.login.repository.CustomUserRepository;
import com.login.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final CustomUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void signUp(SignupRequest request) {
        String username = request.getUsername();
        String password = request.getPassword();

        if (username != null && password != null) {
            if (userRepository.getUserByUsername(username) == null) {

                User user = new User(username, passwordEncoder.encode(password));

                userRepository.addAccount(user);
            }
        }
    }

    public String login(LoginRequest request) {
        return null;
    }
}
