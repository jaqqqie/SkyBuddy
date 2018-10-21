package com.example.yuhboi.skybuddy_v2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.example.yuhboi.skybuddy_v2.MainActivity.cart;
import static com.example.yuhboi.skybuddy_v2.MainActivity.seatNumberText;


public class CartActivity extends Activity {
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("users");
    public static Double totalPrice;
    public static TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        printCart(cart);
    }

    public void printCart(ShoppingCart cart) {
        totalPrice = 0.0;
        Button checkoutButton = findViewById(R.id.checkout);
        for (int i = 0; i < cart.getSize(); i++) {
            totalPrice += cart.getItem(i).getPrice();
        }
        ShoppingCartCustomAdapter adapter = new ShoppingCartCustomAdapter(cart.getItems(), this);
        addListenerOnCheckout(checkoutButton);
        ListView listView = (ListView) findViewById(R.id.listviewcart);
        textView = (TextView) findViewById(R.id.totalPriceText);
        listView.setAdapter(adapter);
        textView.setText("Total: $" + Double.toString(totalPrice));
    }

    private void addListenerOnCheckout(Button checkoutButton) {
        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                write();
                Intent cartActivity = new Intent(CartActivity.this, MainActivity.class);
                startActivity(cartActivity);
            }
        });
    }

    private void write() {
        String userID = mDatabase.push().getKey();
        cart.getItems();
        System.out.println(seatNumberText);
        User user = new User(seatNumberText, cart.getItems());
        mDatabase.child(userID).setValue(user);
    }
}