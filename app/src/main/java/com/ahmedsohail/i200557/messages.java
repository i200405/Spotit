package com.ahmedsohail.i200557;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class messages extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);
    }
    public void audio(View view1) {
        Intent intent1 = new Intent(this, audioCall.class);
        startActivity(intent1);
    }
    public void vc(View view2) {
        Intent intent2 = new Intent(this, videoCall.class);
        startActivity(intent2);
    }
}