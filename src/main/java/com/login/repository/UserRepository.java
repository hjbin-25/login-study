package com.login.repository;

import com.login.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

//    Optional<User> findByUsername(String username);
}
