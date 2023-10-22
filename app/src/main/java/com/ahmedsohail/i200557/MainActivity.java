package com.ahmedsohail.i200557;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    TextView forget;
    TextView signup;
    Button login,logout;

    EditText email_log, password_log;
    FirebaseAuth mAuth;

    String em,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        forget =  findViewById(R.id.forgot_pass);
        signup = findViewById(R.id.signup);
        login = findViewById(R.id.button);
        email_log = findViewById(R.id.email);
        password_log = findViewById(R.id.password);
        mAuth = FirebaseAuth.getInstance();
        //logout = findViewById(R.id.logout_main);

        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,forgotpassword.class);
                startActivity(i);
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s = new Intent(MainActivity.this,registration.class);
                startActivity(s);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                em = email_log.getText().toString();
                pass  = password_log.getText().toString();

                if(TextUtils.isEmpty(em)){
                    Toast.makeText(MainActivity.this, "Enter Email", Toast.LENGTH_SHORT).show();
                    email_log.setError("Email is required");
                    email_log.requestFocus();
                    return;
                } else if (TextUtils.isEmpty(pass)) {
                    Toast.makeText(MainActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    password_log.setError("Password is required");
                    password_log.requestFocus();
                    return;

                }

                mAuth.signInWithEmailAndPassword(email_log.getText().toString(),password_log.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Intent log = new Intent(MainActivity.this, Frags.class);
                                startActivity(log);
                                Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                            }
                        });

            }
        });

    }

}