package com.example.android_project.Chat;

public class ChatDTO {
    private int chat_image;
    private String chat_name, chat_date, chat_msg;

    public ChatDTO(int chat_image, String chat_name, String chat_date, String chat_msg) {
        this.chat_image = chat_image;
        this.chat_name = chat_name;
        this.chat_date = chat_date;
        this.chat_msg = chat_msg;
    }

    public int getChat_image() {
        return chat_image;
    }

    public void setChat_image(int chat_image) {
        this.chat_image = chat_image;
    }

    public String getChat_name() {
        return chat_name;
    }

    public void setChat_name(String chat_name) {
        this.chat_name = chat_name;
    }

    public String getChat_date() {
        return chat_date;
    }

    public void setChat_date(String chat_date) {
        this.chat_date = chat_date;
    }

    public String getChat_msg() {
        return chat_msg;
    }

    public void setChat_msg(String chat_msg) {
        this.chat_msg = chat_msg;
    }
}
