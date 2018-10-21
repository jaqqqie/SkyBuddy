package com.example.yuhboi.skybuddy_v2;

import java.lang.reflect.Array;
import java.util.List;

public class User {
    private String seatNumber;
    private List<Item> shoppingCart;

    User(String seatNumber, List<Item> shoppingCart){
        this.seatNumber = seatNumber;
        this.shoppingCart = shoppingCart;
    }
    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public List<Item> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(List<Item> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}

