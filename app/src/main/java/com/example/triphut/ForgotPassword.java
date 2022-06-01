package com.example.triphut;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {


    private EditText emaileditText;
    private Button resetpassbtn;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        emaileditText= findViewById(R.id.forgotemail);
        resetpassbtn= findViewById(R.id.resetbtn);
        auth=FirebaseAuth.getInstance();
        resetpassbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetPassword();
            }
        });
    }

    private void resetPassword() {
        String email = emaileditText.getText().toString().trim();
        if(email.isEmpty()){
            emaileditText.setError("Email is required");
            emaileditText.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emaileditText.setError("Please Provide Valid Email");
            emaileditText.requestFocus();
            return;
        }
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(ForgotPassword.this, "Check Your Email To Reset Your Password", Toast.LENGTH_LONG).show();

                    startActivity(new Intent(getApplicationContext(),login.class));
                    finish();
                }
                else{
                    Toast.makeText(ForgotPassword.this, "Try Again!Somthing went Wrong!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}