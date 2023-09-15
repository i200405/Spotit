package com.ahmedsohail.i200557;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    public void signup(View view1) {
        Intent intent1 = new Intent(this,emailVerification.class);
        startActivity(intent1);
    }

    public void login(View view2) {

        Intent intent2 = new Intent(this,MainActivity.class);

        startActivity(intent2);
    }

}