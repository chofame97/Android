package com.example.cloneapp.MainView;

public class MemberDTO {
    private String title,location,price;
    private int img;
    public MemberDTO() {

    }

    public MemberDTO(String title, String location, String price, int img) {
        this.title = title;
        this.location = location;
        this.price = price;
        this.img = img;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
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


}
