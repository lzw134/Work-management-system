package com.example.serviceimpl;


import com.example.dao.AboutDao;
import com.example.daoimpl.AboutDaoImpl;
import com.example.entity.About;
import com.example.service.AboutService;


public class AboutServiceImpl implements AboutService {
    /*引入Dao层接口实现类*/
    AboutDao aboutdao = new AboutDaoImpl();

    /*Service层根据id查询数据*/
    public About queryaboutbyid(int id) {
        return aboutdao.QueryAboutById(id);
    }

    /*Service层插入数据*/
    public int addabout(About about) {
       if(aboutdao.isExist(about.getId())){
           return aboutdao.AddAbout(about);
       }else{
           return 0;
       }
    }

    /*Service层插入数据*/
    public int updateabout(About about) {
        if(!aboutdao.isExist(about.getId())){
            return aboutdao.UpdateAbout(about);
        }else{
            return 0;
        }
    }
}
