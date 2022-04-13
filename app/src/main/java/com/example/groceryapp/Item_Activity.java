package com.example.groceryapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Item_Activity extends AppCompatActivity {

    int i,q=0;
    String s="",qs="";
    ImageView image;
    TextView text,quantity;
    Button back,minus,plus,add_cart;
    ArrayList<String> Items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        i = getIntent().getExtras().getInt("Image");
        s = getIntent().getExtras().getString("String");
//        back = (Button) findViewById(R.id.custom_back_button);
        image = (ImageView) findViewById(R.id.item_image_display);
        text = (TextView) findViewById(R.id.item_text_display);
        minus = (Button) findViewById(R.id.minus_button);
        quantity = (TextView) findViewById(R.id.item_quantity);
        plus = (Button) findViewById(R.id.plus_button);
        add_cart = (Button) findViewById(R.id.add_to_cart_button);
        image.setImageResource(i);
        text.setText(s);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Item_Activity.this, SubList.class);
                startActivity(intent);
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                qs = quantity.getText().toString();
                if(qs.contains("g"))
                {
                    qs = qs.replace(" g","");
                    q = Integer.parseInt(qs);
                    q = (q - 250);
                    if (q == 0) {
                        quantity.setText("0");
                    }
                    else
                    {
                        quantity.setText((Integer.toString(q)).concat(" g"));
                    }
                }
                else
                {
                    quantity.setText("0");
                }
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                qs = quantity.getText().toString();
                if(qs.contains("g"))
                {
                    qs = qs.replace(" g","");
                    q = Integer.parseInt(qs);
                    q = (q + 250);
                    quantity.setText((Integer.toString(q)).concat(" g"));
                }
                else
                {
                    q = Integer.parseInt(qs);
                    q = (q + 250);
                    quantity.setText((Integer.toString(q)).concat(" g"));
                }
            }
        });

        add_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((quantity.getText().toString()).contains("g"))
                {
                    Items.add((text.getText().toString()) + "=" + (quantity.getText().toString()));
                    Intent intent = new Intent(Item_Activity.this, SubList.class);
                    intent.putExtra("True",1);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(Item_Activity.this, "Set a quantity first !", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}