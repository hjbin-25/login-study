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

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public void signup(SignupRequest request) {
        String username = request.getUsername();
        String password = request.getPassword();

        if (username != null && password != null) {
            if (userRepository.findByUsername(username).isEmpty()) {
                User user = new User(username, passwordEncoder.encode(password));
                userRepository.save(user);  // DB 저장
            }
        }
    }

    public String login(LoginRequest request) {
        String username = request.getUsername();
        String password = request.getPassword();

        System.out.println("Login attempt - username: " + username + ", password: " + password);

        if (username == null || password == null) {
            System.out.println("Login fail: username or password is null");
            return "login_fail";
        }

        Optional<User> userOpt = userRepository.findByUsername(username);
        if (userOpt.isEmpty()) {
            System.out.println("Login fail: user not found");
            return "login_fail";
        }

        User user = userOpt.get();
        System.out.println("Stored hashed password: " + user.getPassword());

        if (passwordEncoder.matches(password, user.getPassword())) {
            System.out.println("Login success");
            return jwtUtil.generateToken(username);
        } else {
            System.out.println("Login fail: password mismatch");
            return "login_fail";
        }
    }

}
