package com.example.entity;

public class About {
    private int id;
    private String about;
    public  About(int id,String about){
        this.id = id;
        this.about  = about;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAbout(String about) {
        this.about = about;
    }
    public String getAbout() {
        return about;
    }
}
