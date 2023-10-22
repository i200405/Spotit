package com.ahmedsohail.i200557;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Bundle;

import com.ahmedsohail.i200557.databinding.ActivityFragsBinding;

public class Frags extends AppCompatActivity {

    ActivityFragsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityFragsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new HomeFragment());
        binding.navbar.setBackground(null);

        binding.navbar.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.home) {
                replaceFragment(new HomeFragment());
                return true;
            }
            else if (id==R.id.search) {
                replaceFragment(new SearchFragment());
                return  true;
            }

            else if (id==R.id.add) {
                replaceFragment(new AddFragment());
                return  true;
            }
            else if (id==R.id.chat) {
                replaceFragment(new ChatFragment());
                return  true;
            }
            else if (id==R.id.profile) {
                replaceFragment(new ProfileFragment());
                return  true;
            }
            return true;
        });
    }

    private  void  replaceFragment (Fragment fragment)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,fragment);
        fragmentTransaction.commit();
    }


        }





