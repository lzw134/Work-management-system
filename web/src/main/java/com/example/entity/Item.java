package com.example.entity;


public class Item {

  private int id;
  private String child1;
  private String child2;
  private String child3;
  private String child4;
  private String child5;

  public  Item(int id, String child1, String child2, String child3, String child4, String child5){
    this.id = id;
    this.child1 = child1;
    this.child2 = child2;
    this.child3 = child3;
    this.child4 = child4;
    this.child5 = child5;
  }
  public  Item(String child1, String child2, String child3, String child4, String child5){
    this.child1 = child1;
    this.child2 = child2;
    this.child3 = child3;
    this.child4 = child4;
    this.child5 = child5;
  }
  public  Item(int id){
    this.id = id;
  }
  public long getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getChild1() {
    return child1;
  }

  public void setChild1(String child1) {
    this.child1 = child1;
  }


  public String getChild2() {
    return child2;
  }

  public void setChild2(String child2) {
    this.child2 = child2;
  }


  public String getChild3() {
    return child3;
  }

  public void setChild3(String child3) {
    this.child3 = child3;
  }


  public String getChild4() {
    return child4;
  }

  public void setChild4(String child4) {
    this.child4 = child4;
  }


  public String getChild5() {
    return child5;
  }

  public void setChild5(String child5) {
    this.child5 = child5;
  }

}
