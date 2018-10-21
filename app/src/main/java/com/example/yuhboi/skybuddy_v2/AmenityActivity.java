package com.example.yuhboi.skybuddy_v2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class AmenityActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amenity);
        Button cartButton = findViewById(R.id.shoppingcart);
        //generate list
        ArrayList<Item> list = new ArrayList<Item>();
        Item item = new Item("Blanket");
        Item item1 = new Item("Headphones");
        Item item2 = new Item("Pillow");
        Item item3 = new Item("Moist Towelette");
        list.add(item);
        list.add(item1);
        list.add(item3);
        list.add(item2);

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
                Intent cartActivity = new Intent(AmenityActivity.this, CartActivity.class);
                startActivity(cartActivity);
            }
        });
    }
}

