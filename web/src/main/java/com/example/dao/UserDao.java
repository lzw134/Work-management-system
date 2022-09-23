package com.example.dao;

import com.example.entity.User;

public interface UserDao {
    public boolean isExist(User user);
    public User QueryItemById(User user);
    public User QueryUserByForGet(User user);
    public int AddUser(User user);
    public int UpdateUser(User user);
}
