package com.login.repository;

import com.login.domain.User;

public interface CustomUserRepository {
    boolean addAccount(User user);
    User getUserByUsername(String username);
}
