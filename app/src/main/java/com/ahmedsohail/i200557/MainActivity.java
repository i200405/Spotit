package com.ahmedsohail.i200557;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void forgetPassword(View view)
    {

        Intent intent = new Intent(this, forgotpassword.class);
        startActivity(intent);
    }

    public void login(View view2) {

        Intent intent2 = new Intent(this,home.class);

        startActivity(intent2);
    }

    public void signup(View view3) {
        Intent intent3 = new Intent(this,registration.class);

        startActivity(intent3);
    }
}