package com.ahmedsohail.i200557;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class chat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
    }
    public void search(View view) {
        Intent intent1 = new Intent(this, search.class);
        startActivity(intent1);
    }

    public void home(View view2) {
        Intent intent2 = new Intent(this, home.class);
        startActivity(intent2);
    }
    public void profile(View view3) {
        Intent intent3 = new Intent(this, profile.class);
        startActivity(intent3);
    }
    public void mess(View view4) {
        Intent intent4 = new Intent(this, messages.class);
        startActivity(intent4);
    }
    public void add(View view5) {
        Intent intent5 = new Intent(this, postItem.class);
        startActivity(intent5);
    }
}