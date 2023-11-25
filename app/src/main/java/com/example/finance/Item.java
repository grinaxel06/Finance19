package com.example.finance;

public class Item {
    private String title;
    private String money;
    private String date;
    private boolean RoG;
    public Item(String title, String money,String date,boolean RoG){
        this.title =title;
        this.RoG  = RoG;
        this.money = money;
        this.date = date;
    }

    public String getMoney() {
        return money;
    }
    public boolean getBol(){return RoG;}
    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }
}

