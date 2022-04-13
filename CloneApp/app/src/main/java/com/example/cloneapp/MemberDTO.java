package com.example.cloneapp;

import android.media.Image;
import android.widget.ImageView;

public class MemberDTO {
    private String id,pw;

    private String title,location,price,testimg;
    private ImageView img;

    public MemberDTO() {

    }

    public MemberDTO(String title, String location, String price) {
        this.title = title;
        this.location = location;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

}
