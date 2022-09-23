package com.example.service;

import com.example.entity.Person;

public interface PersonService {
    public int addPerson(Person person);
    public int updatePerson(Person person);
    public Person selectPerson(Person person);
}
