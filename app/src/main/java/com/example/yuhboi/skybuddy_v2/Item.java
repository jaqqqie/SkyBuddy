package com.example.yuhboi.skybuddy_v2;

public class Item {
    public String name;
    public double price;

    public Item() {
    }

    public Item(String name) {
        this.name = name;
        this.price = 0;
    }
    public Item(String name, double price){
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String item) {
        this.name = item;
    }
}

