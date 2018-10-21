package com.example.yuhboi.skybuddy_v2;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    public ArrayList<Item> Items;

    public ShoppingCart() {
        Items = new ArrayList<Item>();
    }
    public ShoppingCart(Item item) {
        Items = new ArrayList<Item>();
        Items.add(item);
    }

    public List<Item> getItems() {
        return Items;
    }

    public void setItems(ArrayList<Item> items) {
        Items = items;
    }

    public void addItem(Item item){
        Items.add(item);
    }
    public void removeItem(Item item){
        Items.remove(item);
    }
    public int getSize(){
        return Items.size();
    }
    public Item getItem(int i){
        return Items.get(i);
    }
}