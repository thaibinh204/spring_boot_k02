package com.k02.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
