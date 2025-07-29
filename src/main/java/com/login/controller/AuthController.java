package com.login.controller;

import com.login.dto.LoginRequest;
import com.login.dto.SignupRequest;
import com.login.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public String signup(@RequestBody SignupRequest request) {
        authService.signup(request);
        return "회원가입 성공";
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest request) {
        String token = authService.login(request);
        if ("login_fail".equals(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials");
        }
        return Map.of("token", token);
    }

}