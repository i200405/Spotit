package com.ahmedsohail.i200557;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void search(View view) {
        Intent intent1 = new Intent(this, search.class);
        startActivity(intent1);
    }

    public void chat(View view2) {
        Intent intent2 = new Intent(this, chat.class);
        startActivity(intent2);
    }
    public void profile(View view3) {
        Intent intent3 = new Intent(this, profile.class);
        startActivity(intent3);
    }
    public void item(View view4) {
        Intent intent4 = new Intent(this, item.class);
        startActivity(intent4);
    }
}