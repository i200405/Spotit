package com.ahmedsohail.i200557;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddFragment extends Fragment {

    EditText name,city,date,rate;
    AppCompatButton button;
    FirebaseFirestore db;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddFragment newInstance(String param1, String param2) {
        AddFragment fragment = new AddFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_add, container, false);


        ImageButton button1 = view.findViewById(R.id.uimage);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the new Activity
                Intent intent = new Intent(getActivity(), photocam.class);

                // If you need to pass data to the Activity, you can use Intent extras
                // intent.putExtra("key", "value");

                // Start the Activity
                startActivity(intent);
            }
        });

        ImageButton button2 = view.findViewById(R.id.uvideo);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                // Create an Intent to start the new Activity
                Intent intent2 = new Intent(getActivity(), Videocam2.class);

                // If you need to pass data to the Activity, you can use Intent extras
                // intent.putExtra("key", "value");

                // Start the Activity
                startActivity(intent2);
            }
        });



        db = FirebaseFirestore.getInstance();
        name = view.findViewById(R.id.name);
        rate = view.findViewById(R.id.rate);
        date = view.findViewById(R.id.date);
        city = view.findViewById(R.id.city);
        button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Name = name.getText().toString();
                String Rate = rate.getText().toString();
                String Date = date.getText().toString();
                String City = city.getText().toString();
                Map<String,Object> user = new HashMap<>();
                user.put("Name",Name);
                user.put("Hourly Rate",Rate);
                user.put("Description",Date);
                user.put("City",City);

                db.collection("items")
                        .add(user)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(getContext(),"Successful",Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull @NotNull Exception e) {

                                Toast.makeText(getContext(),"Failed",Toast.LENGTH_SHORT).show();


                            }
                        });

            }
        });





        return view;
    }
}