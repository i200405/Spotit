package com.ahmedsohail.i200557;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Videocam2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videocam2);
    }
    public void photo(View view1) {
        Intent intent1 = new Intent(this, photocam.class);
        startActivity(intent1);
    }
}