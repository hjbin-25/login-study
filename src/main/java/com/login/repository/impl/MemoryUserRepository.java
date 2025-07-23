package com.login.repository.impl;

import com.login.domain.User;
import com.login.repository.CustomUserRepository;

import java.util.HashMap;
import java.util.Map;

public class MemoryUserRepository implements CustomUserRepository {

    Map<String, User> accounts = new HashMap<>();

    @Override
    public boolean addAccount(User user) {
        String username = user.getUsername();

        if (!accounts.containsKey(username)) {
            accounts.put(username, user);

            return true;
        }

        return false;
    }

    @Override
    public User getUserByUsername(String username) {
        if (accounts.containsKey(username)) {
            return accounts.get(username);
        }

        return null;
    }
}
