package com.example.cloneapp.My;

public class MyDTO {
    private String txt;
    private int img;

    public MyDTO(String txt, int img) {
        this.txt = txt;
        this.img = img;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
