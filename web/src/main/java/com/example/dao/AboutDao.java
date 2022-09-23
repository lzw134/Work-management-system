package com.example.dao;

import com.example.entity.About;

public interface AboutDao {
    public boolean isExist(int id);
    public About QueryAboutById(int i);
    public int AddAbout(About about);
    public int UpdateAbout(About about);
}
