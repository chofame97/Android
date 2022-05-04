package com.example.android_project.community;

public class CommunityDTO {
    private int img_url;
    private String category,content, name, location, time, like,comments,cnt;

    public CommunityDTO(int img_url, String category, String content, String name, String location, String time, String like, String comments, String cnt) {
        this.img_url = img_url;
        this.category = category;
        this.content = content;
        this.name = name;
        this.location = location;
        this.time = time;
        this.like = like;
        this.comments = comments;
        this.cnt = cnt;
    }

    public int getImg_url() {
        return img_url;
    }

    public void setImg_url(int img_url) {
        this.img_url = img_url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCnt() {
        return cnt;
    }

    public void setCnt(String cnt) {
        this.cnt = cnt;
    }
}
