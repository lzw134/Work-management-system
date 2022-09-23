package com.example.dao;

import com.example.entity.Person;

public interface PersonDao{
    public int AddPerson(Person person);
    public int UpdatePerson(Person person);
    public Person QueryPersonByIdcard(Person person);
}
