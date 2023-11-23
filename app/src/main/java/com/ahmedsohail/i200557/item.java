package com.ahmedsohail.i200557;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class item extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        //sIntent intent = getIntent();
       /* if (intent != null && intent.hasExtra("key")) {
            String itemName = intent.getStringExtra("key");
            // Do something with the data (e.g., display it in a TextView)
            TextView textView = findViewById(R.id.textView1);
            textView.setText(itemName);
        }*/

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