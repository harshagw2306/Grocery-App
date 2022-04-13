package com.example.groceryapp.PhoneLogin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.groceryapp.MainActivity;
import com.example.groceryapp.R;
import com.example.groceryapp.databinding.ActivityMainBinding;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;


public class RegistrationActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    Button btn_Send;
    EditText et_Phone,et_Name;
    ProgressBar progressBar;
    String name;
    String phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        binding= ActivityRegistrationActivityBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_registration);
//
        mAuth = FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser()!=null){
            startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
            finish();
        }
        btn_Send=findViewById(R.id.btn_Send);
        et_Phone=findViewById(R.id.et_Phone);
        et_Name=findViewById(R.id.et_Name);

        progressBar=findViewById(R.id.progressBar);
        btn_Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_Phone.getText().toString().trim().isEmpty()) {
                    Toast.makeText(RegistrationActivity.this, "Invalid Phone Number", Toast.LENGTH_SHORT).show();
                } else if (et_Phone.getText().toString().trim().length() != 10) {
                    Toast.makeText(RegistrationActivity.this, "Type valid Phone Number", Toast.LENGTH_SHORT).show();
                } else {
                    phone="+91"+et_Phone.getText().toString();
                    name=et_Name.getText().toString();

                    otpSend(phone,name);
//                    Intent intent= new Intent(RegistrationActivity.this,VerifyActivity.class);
                }
            }
        });
    }

    private void otpSend(String phone,String name) {
        progressBar.setVisibility(View.VISIBLE);
        btn_Send.setVisibility(View.INVISIBLE);

        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onVerificationCompleted(PhoneAuthCredential credential) {
                progressBar.setVisibility(View.GONE);
                btn_Send.setVisibility(View.VISIBLE);
            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                progressBar.setVisibility(View.GONE);
                btn_Send.setVisibility(View.VISIBLE);
                Toast.makeText(RegistrationActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCodeSent(@NonNull String verificationId,
                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {
                progressBar.setVisibility(View.GONE);
                btn_Send.setVisibility(View.VISIBLE);
                Toast.makeText(RegistrationActivity.this, "OTP is successfully send.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegistrationActivity.this, VerifyActivity.class);
                intent.putExtra("phone", phone);
                intent.putExtra("name",name);
                intent.putExtra("verificationId", verificationId);
                Log.e("verify_btn","why crashing?");
                startActivity(intent);
                finish();
            }
        };

        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber(phone)

                        .setTimeout(60L, TimeUnit.SECONDS)
                        .setActivity(this)
                        .setCallbacks(mCallbacks)
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
        Log.d("grocery","auth started");
    }
}