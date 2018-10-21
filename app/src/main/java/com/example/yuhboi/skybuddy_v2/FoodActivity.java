package com.example.yuhboi.skybuddy_v2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class FoodActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        Button cartButton = findViewById(R.id.shoppingcart);
        //generate list
        ArrayList<Item> list = new ArrayList<Item>();
        Item item = new Item("Muffin", 2.2);
        Item item1 = new Item("Pasta", .5);
        Item item2 = new Item("Pretzels", .75);
        Item item3 = new Item("Peanuts", 1);
        list.add(item);
        list.add(item1);
        list.add(item2);
        list.add(item3);

        //instantiate custom adapter
        CustomAdapter adapter = new CustomAdapter(list, this);
        addListenerOnShoppingCart(cartButton);
        //handle listview and assign adapter
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
    }

    private void addListenerOnShoppingCart(Button cartButton) {
        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cartActivity = new Intent(FoodActivity.this, CartActivity.class);
                startActivity(cartActivity);
            }
        });
    }
}

