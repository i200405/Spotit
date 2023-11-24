package com.ahmedsohail.i200557;
//import android.annotation.SuppressLint;
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.AppCompatButton;
//
//
//import com.ahmedsohail.i200557.Models.Users;
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.OnFailureListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.storage.FirebaseStorage;
//import com.google.firebase.storage.StorageReference;
//
//public class registration extends AppCompatActivity {
//    AppCompatButton sign;
//    Button log;
//    EditText name,contNo;
//
//    Uri ImageUri;
//    String imageuri;
//
//
//    EditText editText_email,editText_password;
//    FirebaseAuth mAuth;
//
//    FirebaseDatabase database;
//    FirebaseStorage storage;
//    @SuppressLint("MissingInflatedId")
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_registration);
//
//        sign = findViewById(R.id.button);
//        log = findViewById(R.id.log_in);
//        editText_email = findViewById(R.id.email_reg);
//        editText_password = findViewById(R.id.password_reg);
//        name = findViewById(R.id.sname);
//        contNo = findViewById(R.id.sContNo);
//        mAuth = FirebaseAuth.getInstance();
//        database = FirebaseDatabase.getInstance();
//        storage = FirebaseStorage.getInstance();
//
//        sign.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                String em = editText_email.getText().toString();
//                String pa = editText_password.getText().toString();
//                String na = name.getText().toString();
//                String cn = contNo.getText().toString();
//
//                if (TextUtils.isEmpty(em)) {
//                    Toast.makeText(registration.this, "Enter Email", Toast.LENGTH_LONG).show();
//                    editText_email.setError("Email is Required");
//                    editText_email.requestFocus();
//                    return;
//                } else if (TextUtils.isEmpty(pa)) {
//                    Toast.makeText(registration.this, "Enter Password", Toast.LENGTH_LONG).show();
//                    editText_password.setError("Password is Required");
//                    editText_password.requestFocus();
//                    return;
//                }
//                else if (TextUtils.isEmpty(na)) {
//                    Toast.makeText(registration.this, "Enter Name", Toast.LENGTH_LONG).show();
//                    name.setError("Name is Required");
//                    name.requestFocus();
//                    return;
//                }
//                else if (TextUtils.isEmpty(cn)) {
//                    Toast.makeText(registration.this, "Enter Contact Number", Toast.LENGTH_LONG).show();
//                    contNo.setError("Contact Number is Required");
//                    contNo.requestFocus();
//                    return;
//                }
//
//                mAuth.createUserWithEmailAndPassword(editText_email.getText().toString(),editText_password.getText().toString())
//                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                            @Override
//                            public void onComplete(@NonNull Task<AuthResult> task) {
//
//                                String id = task.getResult().getUser().getUid();
//                                DatabaseReference reference = database.getReference().child("user").child(id);
//                                StorageReference storageReference = storage.getReference().child("upload").child(id);
//
//                                imageuri = "https://firebasestorage.googleapis.com/v0/b/spotit-ae438.appspot.com/o/man.png?alt=media&token=d970fe9f-b356-40e2-8d44-8548e197675e";
//
//                                Users users = new Users(imageuri,na,pa,em,cn);
//                                reference.setValue(users).addOnCompleteListener(new OnCompleteListener<Void>() {
//                                    @Override
//                                    public void onComplete(@NonNull Task<Void> task) {
//                                        if(task.isSuccessful()){
//                                            Intent in = new Intent(registration.this, ChatFragment.class);
//                                            Toast.makeText(registration.this, "Sign Up Success", Toast.LENGTH_SHORT).show();
//                                        }
//                                    }
//                                });
//
//
//
//                            }
//                        })
//                        .addOnFailureListener(new OnFailureListener() {
//                            @Override
//                            public void onFailure(@NonNull Exception e) {
//                                Toast.makeText(registration.this, "Sign Up Failed", Toast.LENGTH_SHORT).show();
//                            }
//                        });
//
//
//            }
//
//        });
//        log.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent lo = new Intent(registration.this , MainActivity.class);
//                startActivity(lo);
//            }
//        });
//    }
//
//
//}


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.ahmedsohail.i200557.MainActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class registration extends AppCompatActivity {

    EditText usernameEditText, emailEditText, phnoEditText, passwordEditText;
    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        usernameEditText = findViewById(R.id.sname);
        emailEditText = findViewById(R.id.email_reg);
        phnoEditText = findViewById(R.id.sContNo);
        passwordEditText = findViewById(R.id.password_reg);
        registerButton = findViewById(R.id.button);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String phno = phnoEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Validate inputs
                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(email) || TextUtils.isEmpty(phno) || TextUtils.isEmpty(password)) {
                    Toast.makeText(registration.this, "All fields are required", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Make a POST request to your API
                makeRegistrationRequest(username, email, phno, password);
            }
        });
    }

    private void makeRegistrationRequest(String username, String email, String phno, String password) {
        String url = "http://192.168.56.1/Spotit_Api/register.php"; // Replace with your API endpoint URL

        JSONObject postData = new JSONObject();
        try {
            postData.put("username", username);
            postData.put("email", email);
            postData.put("phno", phno);
            postData.put("password", password);

            Log.d("JSON_DATA", "Request JSON: " + postData.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, postData,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String message = response.getString("message");
                            Toast.makeText(registration.this, message, Toast.LENGTH_SHORT).show();

                            // If registration is successful, navigate to login activity or perform desired actions
                            if (message.equals("Registration successful")) {
                                Intent intent = new Intent(registration.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(registration.this, "Error parsing response", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String message;
                if (error.networkResponse != null && error.networkResponse.data != null) {
                    // If there's a network response with data available
                    try {
                        String errorResponse = new String(error.networkResponse.data, "UTF-8");
                        message = "Registration failed: " + errorResponse;
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        message = "Registration failed: Unknown error";
                        Log.e("Volley_Error", "Unsupported Encoding Exception: " + e.getMessage());
                    }
                } else if (error.getMessage() != null) {
                    // If there's an error message available
                    message = "Registration failed: " + error.getMessage();
                } else {
                    // If no specific error message is available
                    message = "Registration failed: Unknown error";
                }
                Toast.makeText(registration.this, message, Toast.LENGTH_SHORT).show();
            }

        });

        requestQueue.add(jsonObjectRequest);
    }
}
