package com.example.entity;


public class User {

  private int id;
  private String iphone;
  private String idcards;
  private String pwd;

  public User(int id,String iphone,String idcards,String pwd){
    this.id = id;
    this.iphone = iphone;
    this.idcards = idcards;
    this.pwd = pwd;
  }


  public User(String iphone,String idcards,String pwd){
    this.iphone = iphone;
    this.idcards = idcards;
    this.pwd = pwd;
  }

  public User(String iphone,String pwd){
    this.iphone = iphone;
    this.pwd = pwd;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getIphone() {
    return iphone;
  }

  public void setIphone(String iphone) {
    this.iphone = iphone;
  }


  public String getIdcards() {
    return idcards;
  }

  public void setIdcards(String idcards) {
    this.idcards = idcards;
  }


  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

}
