package com.example.service;

import com.example.entity.About;

public interface AboutService {
    public About queryaboutbyid(int id);
    public int addabout(About about);
    public int updateabout(About about);
}
