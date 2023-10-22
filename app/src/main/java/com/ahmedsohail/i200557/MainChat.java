package com.ahmedsohail.i200557;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;


import com.ahmedsohail.i200557.Models.Users;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainChat extends AppCompatActivity {

    RecyclerView rv;
    FirebaseAuth mAuth;
    UserAdapter adapter;
    FirebaseDatabase database;
    ArrayList<Users> usersArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_chat);

        rv = findViewById(R.id.main_chat);
        mAuth = FirebaseAuth.getInstance();
        rv.setLayoutManager(new LinearLayoutManager(this));
        usersArrayList = new ArrayList<>();
        adapter = new UserAdapter(MainChat.this, usersArrayList);
        rv.setAdapter(adapter);

        database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference().child("user");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                usersArrayList.clear(); // Clear the existing data
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Users users = dataSnapshot.getValue(Users.class);
                    usersArrayList.add(users);

                    Log.d("DataRetrieval", "User: " + users.getUserName());
                }
                adapter.notifyDataSetChanged(); // Notify the adapter of data changes
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle database error
                Log.e("DataRetrievalError", "Failed to retrieve data: " + error.getMessage());
            }
        });
    }
}