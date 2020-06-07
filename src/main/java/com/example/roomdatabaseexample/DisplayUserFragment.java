package com.example.roomdatabaseexample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class DisplayUserFragment extends Fragment {

    TextView displayUsers;

    public DisplayUserFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_display_user, container, false);

        displayUsers = view.findViewById(R.id.textViewDisplayUsers);

        DisplayAllUsers();

        return view;
    }

    public void DisplayAllUsers(){

        List<User> users = MainActivity.myRoomDatabase.myDao().GetAllUsers();

        String info = "";

        for (User user: users){

            int id = user.getId();
            String name = user.getName();
            String email = user.getEmail();

            info = info + "\n\nId: " + id + "\nName: " + name + "\nEmail: " + email;


        }

        displayUsers.setText(info);

    }
}