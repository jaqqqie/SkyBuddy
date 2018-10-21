package com.example.yuhboi.skybuddy_v2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.example.yuhboi.skybuddy_v2.MainActivity.cart;
import static com.example.yuhboi.skybuddy_v2.CartActivity.totalPrice;
import static com.example.yuhboi.skybuddy_v2.CartActivity.textView;

public class ShoppingCartCustomAdapter extends BaseAdapter implements ListAdapter {
    private List<Item> list = new ArrayList<Item>();
    private Context context;


    public ShoppingCartCustomAdapter(List<Item> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int pos) {
        return list.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return 0;
        //just return 0 if your list items do not have an Id variable.
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.shoppingcartcustomlayout, null);
        }

        //Handle TextView and display string from your list
        TextView listItemText = (TextView) view.findViewById(R.id.list_item_string);
        TextView price = (TextView) view.findViewById(R.id.price);
        listItemText.setText(list.get(position).getName());
        price.setText("$"+Double.toString(list.get(position).getPrice()));
        //Handle buttons and add onClickListeners
        Button addBtn = (Button) view.findViewById(R.id.add_btn);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do something
                Double diff = list.get(position).getPrice();
                totalPrice -= diff;
                textView.setText("Total: $" + Double.toString(totalPrice));

                cart.removeItem(list.get(position));
                notifyDataSetChanged();
            }
        });
        return view;
    }
}