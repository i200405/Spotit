package com.ahmedsohail.i200557;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class item extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
    }
    public void report(View view3) {
        Intent intent3 = new Intent(this, report.class);
        startActivity(intent3);
    }
    public void search(View view1) {
        Intent intent1 = new Intent(this, searchResults.class);
        startActivity(intent1);
    }

}