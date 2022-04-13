package com.example.groceryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.groceryapp.Adapters.ListAdapter;
import com.example.groceryapp.Models.UserModel;
import com.example.groceryapp.PhoneLogin.RegistrationActivity;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

TextView profile_name;
FirebaseAuth  mAuth;
String userName,phone_number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth=FirebaseAuth.getInstance();

        GridView broadListGrid=findViewById(R.id.broadListGrid);

        String []broadListItemName={"Aata","Cooking oil","Rava","Vrat Aata",
                                     "Lentils","Dry Fruits","Sugar & Jaggery",
                                     "Tea","Spices","Gluten Free Snack","Rajastani Sabjiya",
                                     "Milk Powder","Frozen Fruits","For Chocolate Makers",
                                     "Mocktails","For Shakes","For Baking","Sauces","Italian",
                                     "Frozen Items","Frozen Products","Tinned Fruits","Chinese Items"};
        int []broadListItemImage={R.drawable.flour,R.drawable.ghee,R.drawable.rava,R.drawable.kuttu_aata,
                                  R.drawable.lentils_rice,R.drawable.dry_fruits,R.drawable.sugar,
                                  R.drawable.tea,R.drawable.spices,R.drawable.gluten_free_snacks,
                                  R.drawable.rajastani_sabjiya,R.drawable.milk_powder,R.drawable.frozen_fruits,
                                  R.drawable.chocoloate_makers,R.drawable.mocktails,R.drawable.shakes,
                                  R.drawable.baking,R.drawable.sauces,R.drawable.pizza,R.drawable.frozen_items,
                                  R.drawable.frozen_cook,R.drawable.tinned_fruits,R.drawable.chinese_items};

        ListAdapter adapter=new ListAdapter(MainActivity.this,broadListItemName,broadListItemImage);
        broadListGrid.setAdapter(adapter);

        broadListGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent=new Intent(MainActivity.this,SubList.class);
                intent.putExtra("Position",position);
                startActivity(intent);

            }
        });
        UserModel model=new UserModel();

        MaterialToolbar toolbar=findViewById(R.id.topAppbar);
        DrawerLayout drawerLayout=findViewById(R.id.drawerLayout);
        NavigationView navigationView=findViewById(R.id.navigationView);
        View navigation_profile=navigationView.getHeaderView(0);
        TextView phone_no=navigation_profile.findViewById(R.id.name);
        TextView name=navigation_profile.findViewById(R.id.ph_number);
        userName=getIntent().getStringExtra("name");
        name.setText(userName);
        phone_number=getIntent().getStringExtra("phone_no");
        phone_no.setText(phone_number);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_login:
                        Intent intent=new Intent(MainActivity.this,ProfileActivity.class);
                        intent.putExtra("userName",userName);
                        intent.putExtra("phone_number",phone_number);

                        startActivity(intent);
                }
                return false;
            }
        });


    }
}