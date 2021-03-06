package com.k02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.k02.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
