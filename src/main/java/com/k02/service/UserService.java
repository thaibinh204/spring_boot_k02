package com.k02.service;

import com.k02.entity.User;

public interface UserService {
    void save(User user);
    User findByUserName(String userName);
}
