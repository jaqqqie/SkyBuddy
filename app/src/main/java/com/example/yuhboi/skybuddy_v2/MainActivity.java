package com.example.yuhboi.skybuddy_v2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static ShoppingCart cart = new ShoppingCart();
    public static String seatNumberText;
    public static String empty = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button drinkButton = findViewById(R.id.drink),
                foodButton = findViewById(R.id.food),
                amenityButton = findViewById(R.id.amenity),
                cartButton = findViewById(R.id.shoppingcart);
        addListenerOnDrink(drinkButton);
        addListenerOnFood(foodButton);
        addListenerOnAmenity(amenityButton);
        addListenerOnShoppingCart(cartButton);
    }

    public void addListenerOnDrink(Button drinkButton) {
        drinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText) findViewById(R.id.seatNumber);
                seatNumberText = editText.getText().toString();
                seatNumberText += empty;
                Intent drinkActivity = new Intent(MainActivity.this, DrinkActivity.class);
                startActivity(drinkActivity);
            }
        });
    }

    private void addListenerOnFood(Button foodButton) {
        foodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText) findViewById(R.id.seatNumber);
                seatNumberText = editText.getText().toString();
                seatNumberText += empty;
                Intent foodActivity = new Intent(MainActivity.this, FoodActivity.class);
                startActivity(foodActivity);
            }
        });
    }

    private void addListenerOnAmenity(Button amenityButton) {
        amenityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText) findViewById(R.id.seatNumber);
                seatNumberText = editText.getText().toString();
                seatNumberText += empty;
                Intent amenityActivity = new Intent(MainActivity.this, AmenityActivity.class);
                startActivity(amenityActivity);
            }
        });
    }

    private void addListenerOnShoppingCart(Button cartButton) {
        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText) findViewById(R.id.seatNumber);
                seatNumberText = editText.getText().toString();
                seatNumberText += empty;
                Intent cartActivity = new Intent(MainActivity.this, CartActivity.class);
                startActivity(cartActivity);
            }
        });
    }
}
