package com.login.service;

import com.login.domain.User;
import com.login.dto.LoginRequest;
import com.login.dto.SignupRequest;
import com.login.jwt.JwtUtil;
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
    private final JwtUtil jwtUtil;

    public void signup(SignupRequest request) {
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
        String username = request.getUsername();
        String password = request.getPassword();

        if (username == null && password == null) {
            return "login_fail";
        }

        User user = userRepository.getUserByUsername(username);
        if (user == null) {
            return "login_fail";
        }

        if (passwordEncoder.matches(password, user.getPassword())) {
            return jwtUtil.generateToken(username);
        } else {
            return "login_fail";
        }
    }
}
