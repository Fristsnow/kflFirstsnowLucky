package com.blog.service;

import org.apache.catalina.User;

public interface UserService {
    User findByUsername(String username);

    void register(String username, String password);

}
