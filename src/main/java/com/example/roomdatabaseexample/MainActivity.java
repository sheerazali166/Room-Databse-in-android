package com.example.roomdatabaseexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    public static MyRoomDatabase myRoomDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        myRoomDatabase = Room.databaseBuilder(getApplicationContext(), MyRoomDatabase.class, "user_db").allowMainThreadQueries().build();

        if(findViewById(R.id.frameLayoutContainer) != null){

            if(savedInstanceState != null){
                return;
            }

            fragmentManager.beginTransaction().add(R.id.frameLayoutContainer, new HomeFragment(), null).commit();
        }
    }
}