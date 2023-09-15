package com.ahmedsohail.i200557;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }
    public void search(View view) {
        Intent intent1 = new Intent(this, search.class);
        startActivity(intent1);
    }

    public void chat(View view2) {
        Intent intent2 = new Intent(this, chat.class);
        startActivity(intent2);
    }
    public void home(View view3) {
        Intent intent3 = new Intent(this, home.class);
        startActivity(intent3);
    }
    public void item(View view4) {
        Intent intent4 = new Intent(this, item.class);
        startActivity(intent4);
    }
    public void add(View view5) {
        Intent intent5 = new Intent(this, postItem.class);
        startActivity(intent5);
    }
    public void edit(View view6) {
        Intent intent6 = new Intent(this, editProfile.class);
        startActivity(intent6);
    }
}