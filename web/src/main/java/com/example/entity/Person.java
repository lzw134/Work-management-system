package com.example.entity;


public class Person {

  private long id;
  private String idcard;
  private String username;
  private String title;
  private String education;
  private String birthday;

  public Person(String idcard,String username,String title,String education,String birthday){
    this.idcard = idcard;
    this.username = username;
    this.title = title;
    this.education = education;
    this.birthday = birthday;
  }

  public Person(int id,String idcard,String username,String title,String education,String birthday){
    this.id = id;
    this.idcard = idcard;
    this.username = username;
    this.title = title;
    this.education = education;
    this.birthday = birthday;
  }

  public Person(String idcard){
    this.idcard = idcard;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getIdcard() {
    return idcard;
  }

  public void setIdcard(String idcard) {
    this.idcard = idcard;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getEducation() {
    return education;
  }

  public void setEducation(String education) {
    this.education = education;
  }


  public String getBirthday() {
    return birthday;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

}
