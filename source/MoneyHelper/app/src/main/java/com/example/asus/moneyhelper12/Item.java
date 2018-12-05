package com.example.asus.moneyhelper12;

public class Item {

    private String comment;
    private String data;
    private int money;
    private int id;

    Item(int id,int money, String comment, String data)
    {
        this.id=id;
        this.money=money;
        this.data=data;
        this.comment=comment;

    }

    public int getId(){ return id; }
    public int getMoney(){ return money;}
    public String getData(){return data; }
    public String getComment(){ return comment; }

    public void setId(int id){ this.id=id;}
    public void setComment(String comment) { this.comment = comment; }
    public void setData(String data) { this.data = data; }
    public void setMoney(int money) { this.money = money;}

}
