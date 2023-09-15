package com.ahmedsohail.i200557;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class postItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_item);
    }
    public void image(View view1) {
        Intent intent1 = new Intent(this, photocam.class);
        startActivity(intent1);
    }
    public void video(View view2) {
        Intent intent2 = new Intent(this, Videocam2.class);
        startActivity(intent2);
    }
    public void profile(View view3) {
        Intent intent3 = new Intent(this, profile.class);
        startActivity(intent3);
    }


}