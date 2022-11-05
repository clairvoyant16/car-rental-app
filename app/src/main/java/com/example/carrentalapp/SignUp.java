package com.example.carrentalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {
    TextInputLayout regName, regEmail, regPassword, regPhoneNo, regUsername;
    Button callSignIn, signUpBtn;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        callSignIn = findViewById(R.id.callSignIn);
        regName = findViewById(R.id.name);
        regUsername = findViewById(R.id.username);
        regEmail = findViewById(R.id.email);
        regPhoneNo = findViewById(R.id.phoneNumber);
        regPassword = findViewById(R.id.password);
        signUpBtn = findViewById(R.id.signUpBtn);


        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");
                UserHelperClass helperClass = new UserHelperClass(regName.getEditText().getText().toString(), regUsername.getEditText().getText().toString(), regEmail.getEditText().getText().toString(), regPhoneNo.getEditText().getText().toString(), regPassword.getEditText().getText().toString());
                reference.child(helperClass.username).setValue(helperClass);
                Intent intent = new Intent(SignUp.this, Dashboard.class);
                startActivity(intent);
            }
        });



        callSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this, Login.class);
                startActivity(intent);
            }
        });

    }
}