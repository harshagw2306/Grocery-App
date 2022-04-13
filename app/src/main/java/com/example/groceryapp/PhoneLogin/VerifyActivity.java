package com.example.groceryapp.PhoneLogin;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.groceryapp.MainActivity;
import com.example.groceryapp.Models.UserModel;
import com.example.groceryapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.FirebaseDatabase;


public class VerifyActivity extends AppCompatActivity {

    //    private ActivityOtpVerifyBinding
    private String verificationId,code,name,phone_no;
    TextView tv_Mobile,tvResendBtn;
    EditText etC1,etC2,etC3,etC4,etC5,etC6;
    Button btnVerify;
    ProgressBar progressBarVerify;
    private FirebaseAuth mFirebaseAuth;
    FirebaseDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        = ActivityOtpVerifyBinding.inflate(getLayoutInflater());
        setContentView(R.layout.otp_verification_activity);


        tv_Mobile=findViewById(R.id.tv_Mobile);
        etC1=findViewById(R.id.etC1);
        etC2=findViewById(R.id.etC2);
        etC3=findViewById(R.id.etC3);
        etC4=findViewById(R.id.etC4);
        etC5=findViewById(R.id.etC5);
        etC6=findViewById(R.id.etC6);
        editTextInput();
        mFirebaseAuth=FirebaseAuth.getInstance();
        tvResendBtn=findViewById(R.id.tv_ResendBtn);
        btnVerify=findViewById(R.id.btn_Verify);
        progressBarVerify=findViewById(R.id.progress_BarVerify);
        tv_Mobile.setText(
                 getIntent().getStringExtra("phone")
        );


        database=FirebaseDatabase.getInstance();
        verificationId = getIntent().getStringExtra("verificationId");
        name=getIntent().getStringExtra("name");
        phone_no=getIntent().getStringExtra("phone");
        tvResendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(VerifyActivity.this, "OTP Send Successfully.", Toast.LENGTH_SHORT).show();
            }
        });

        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code = etC1.getText().toString().trim() +
                        etC2.getText().toString().trim() +
                        etC3.getText().toString().trim() +
                        etC4.getText().toString().trim() +
                        etC5.getText().toString().trim() +
                        etC6.getText().toString().trim();
                progressBarVerify.setVisibility(View.VISIBLE);
                btnVerify.setVisibility(View.INVISIBLE);
                if (etC1.getText().toString().trim().isEmpty() ||
                        etC2.getText().toString().trim().isEmpty() ||
                        etC3.getText().toString().trim().isEmpty() ||
                        etC4.getText().toString().trim().isEmpty() ||
                        etC5.getText().toString().trim().isEmpty() ||
                        etC6.getText().toString().trim().isEmpty()) {
                    Toast.makeText(VerifyActivity.this, "OTP is not Valid!", Toast.LENGTH_SHORT).show();
                } else {
                    if (verificationId != null) {

                        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);
                        FirebaseAuth
                                .getInstance()
                                .signInWithCredential(credential)
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull  Task<AuthResult> task) {
                                        if (task.isSuccessful()) {
                                            progressBarVerify.setVisibility(View.VISIBLE);
                                            btnVerify.setVisibility(View.INVISIBLE);

                                            Toast.makeText(VerifyActivity.this, "Welcome...", Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(VerifyActivity.this, MainActivity.class);
                                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                            intent.putExtra("phone_no",phone_no);
                                            intent.putExtra("name",name);

                                            UserModel userModel=new UserModel(name,phone_no);
                                            userModel.setName(name);
                                            userModel.setPh_number(phone_no);
                                            String id=task.getResult().getUser().getUid();
                                            database.getReference().child("Users").child(id).setValue(userModel);
                                            startActivity(intent);
                                            finish();
                                        } else {
                                            progressBarVerify.setVisibility(View.GONE);
                                            btnVerify.setVisibility(View.VISIBLE);
                                            Toast.makeText(VerifyActivity.this, "OTP is not Valid!", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                    }
                }
            }
        });
    }



    private void editTextInput() {
        etC1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                etC2.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etC2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                etC3.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etC3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                etC4.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etC4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                etC5.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etC5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                etC6.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}