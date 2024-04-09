package com.blog.service.impl;

import com.blog.domain.Users;
import com.blog.mapper.UsersMapper;
import com.blog.service.UserService;
import com.blog.utils.Md5Util;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public User findByUsername(String username) {
        return usersMapper.findByUsername(username);
    }

    @Override
    public void register(String username, String password) {
        Users users = new Users();
        users.setUsername(username);
        users.setPassword(Md5Util.getMD5String(password));
        users.setUpdatedAt(LocalDateTime.now());
        users.setCreatedAt(LocalDateTime.now());
        usersMapper.insertSelective(users);
    }
}
