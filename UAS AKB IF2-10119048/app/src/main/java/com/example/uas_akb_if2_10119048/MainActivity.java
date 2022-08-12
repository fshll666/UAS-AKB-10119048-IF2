package com.example.uas_akb_if2_10119048;
/**
 * Nama : Mochamad Faishal
 * Kelas : IF2
 * NIM :10119048
 * Email : faishal.10119048@mahasiswa.unikom.ac.id
 * **/
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.uas_akb_if2_10119048.diary.FragmentNoteActivity;
import com.example.uas_akb_if2_10119048.uinterface.AboutActivity;
import com.example.uas_akb_if2_10119048.uinterface.ProfilActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomnavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialize fragment
//        Fragment fragment = new MyLocationFragment();
//
//        //open Fragment
//        getSupportFragmentManager()
//                .beginTransaction()
//                .replace(R.id.fragment_container,fragment)
//                .commit();

        bottomnavigation = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentNoteActivity()).commit();
        bottomnavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()){
                    case R.id.daily:
                        selectedFragment = new FragmentNoteActivity();
                        break;
                    case R.id.profil:
                        selectedFragment = new ProfilActivity();
                        break;
                    case R.id.about:
                        selectedFragment = new AboutActivity();
                        break;

                    case R.id.logout:
                        selectedFragment = new LogoutActivity();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

                return true;
            }
        });


    }
}