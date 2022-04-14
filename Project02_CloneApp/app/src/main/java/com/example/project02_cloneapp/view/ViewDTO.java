package com.example.project02_cloneapp.view;

public class ViewDTO {
    private int img1 , img2;
    private String title , news_title1 , news_title2 ;

    public ViewDTO(int img1, int img2, String title, String news_title1, String news_title2) {
        this.img1 = img1;
        this.img2 = img2;
        this.title = title;
        this.news_title1 = news_title1;
        this.news_title2 = news_title2;
    }

    public int getImg1() {
        return img1;
    }

    public void setImg1(int img1) {
        this.img1 = img1;
    }

    public int getImg2() {
        return img2;
    }

    public void setImg2(int img2) {
        this.img2 = img2;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNews_title1() {
        return news_title1;
    }

    public void setNews_title1(String news_title1) {
        this.news_title1 = news_title1;
    }

    public String getNews_title2() {
        return news_title2;
    }

    public void setNews_title2(String news_title2) {
        this.news_title2 = news_title2;
    }
}
