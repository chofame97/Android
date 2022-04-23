package com.example.a00vendingmachine;

import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;

public class MachineDTO implements Serializable {
    private String drink;
    private int price;
    private int count;
    private EditText text_in;
    private TextView text_in2,text_coke,text_cider,text_fanta,text_demisoda;
    private int money;
    private int cnt_coke,cnt_cider,cnt_fanta,_cnt_demisoda;

    public MachineDTO(String drink, int price, int count) {
        this.drink = drink;
        this.price = price;
        this.count = count;
    }

    public MachineDTO() {

    }

    public int getCnt_coke() {
        return cnt_coke;
    }

    public void setCnt_coke(int cnt_coke) {
        this.cnt_coke = cnt_coke;
    }

    public int getCnt_cider() {
        return cnt_cider;
    }

    public void setCnt_cider(int cnt_cider) {
        this.cnt_cider = cnt_cider;
    }

    public int getCnt_fanta() {
        return cnt_fanta;
    }

    public void setCnt_fanta(int cnt_fanta) {
        this.cnt_fanta = cnt_fanta;
    }

    public int get_cnt_demisoda() {
        return _cnt_demisoda;
    }

    public void set_cnt_demisoda(int _cnt_demisoda) {
        this._cnt_demisoda = _cnt_demisoda;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public EditText getText_in() {
        return text_in;
    }

    public void setText_in(EditText text_in) {
        this.text_in = text_in;
    }

    public TextView getText_in2() {
        return text_in2;
    }

    public void setText_in2(TextView text_in2) {
        this.text_in2 = text_in2;
    }

    public TextView getText_coke() {
        return text_coke;
    }

    public void setText_coke(TextView text_coke) {
        this.text_coke = text_coke;
    }

    public TextView getText_cider() {
        return text_cider;
    }

    public void setText_cider(TextView text_cider) {
        this.text_cider = text_cider;
    }

    public TextView getText_fanta() {
        return text_fanta;
    }

    public void setText_fanta(TextView text_fanta) {
        this.text_fanta = text_fanta;
    }

    public TextView getText_demisoda() {
        return text_demisoda;
    }

    public void setText_demisoda(TextView text_demisoda) {
        this.text_demisoda = text_demisoda;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
