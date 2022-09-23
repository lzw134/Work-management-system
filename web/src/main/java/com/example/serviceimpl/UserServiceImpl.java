package com.example.serviceimpl;

import com.example.dao.UserDao;
import com.example.daoimpl.UserImpl;
import com.example.entity.User;
import com.example.service.UserService;

public class UserServiceImpl implements UserService {
    /*引入Dao层接口实现类*/
    UserDao userdao = new UserImpl();

    /*注册*/
    public int register(User user){
        if(userdao.isExist(user)){
            return  userdao.AddUser(user);
        }else{
            return 0;
        }
    }

   /*登录*/
   public User login(User user){
       if(!userdao.isExist(user)){
           return userdao.QueryItemById(user);
       }else{
           return null;
       }
   }
   /*修改密码*/
   public int forget(User user){
       if(userdao.QueryUserByForGet(user)!=null){
           return userdao.UpdateUser(user);
       }else{
           return 0;
       }
   }
}
