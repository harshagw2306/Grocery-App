package com.example.groceryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.groceryapp.Models.UserModel;
import com.example.groceryapp.PhoneLogin.RegistrationActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        mAuth=FirebaseAuth.getInstance();
        FirebaseUser user=mAuth.getCurrentUser();
        String number=getIntent().getStringExtra("phone_number");

        String name=getIntent().getStringExtra("userName");
        TextView welcomeText=findViewById(R.id.welcomeText);
        welcomeText.setText(number + "\n"+ name);
        Button logout=findViewById(R.id.buttonLogout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Intent intent=new Intent(ProfileActivity.this, RegistrationActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}