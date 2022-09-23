package com.example.service;

import com.example.entity.User;

public interface UserService {
    public int register(User user);
    public User login(User user);
    public int forget(User user);
}
