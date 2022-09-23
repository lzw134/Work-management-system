package com.example.serviceimpl;

import com.example.dao.PersonDao;
import com.example.daoimpl.PersonDaoImpl;
import com.example.entity.Person;
import com.example.service.PersonService;

public class PersonServiceImpl implements PersonService {
    /*引入Dao层接口实现类*/
    PersonDao persondao = new PersonDaoImpl();

    /*Service层插入数据*/
    public int addPerson(Person person) {
        return persondao.AddPerson(person);
    }

   /*Service层更新数据*/
   public int updatePerson(Person person) {
       return persondao.UpdatePerson(person);
   }

    /*Service层查询数据*/
    public Person selectPerson(Person person) {
        return persondao.QueryPersonByIdcard(person);
    }
}
