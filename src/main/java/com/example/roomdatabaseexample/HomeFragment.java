package com.example.roomdatabaseexample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class HomeFragment extends Fragment implements View.OnClickListener {

    Button buttonHomeFragmentAddUser, buttonHomefragmentDisplayUser, buttonHomefragmentDeleteUser, buttonHomefragmentUpdateUser;

    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        buttonHomeFragmentAddUser = view.findViewById(R.id.buttonHomeFragmentAddUser);
        buttonHomeFragmentAddUser.setOnClickListener(this);

        buttonHomefragmentDisplayUser = view.findViewById(R.id.buttonHomeFragmentDisplayUser);
        buttonHomefragmentDisplayUser.setOnClickListener(this);

        buttonHomefragmentDeleteUser = view.findViewById(R.id.buttonHomeFragmentDeleteUser);
        buttonHomefragmentDeleteUser.setOnClickListener(this);

        buttonHomefragmentUpdateUser = view.findViewById(R.id.buttonHomeFragmentUpdateUser);
        buttonHomefragmentUpdateUser.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.buttonHomeFragmentAddUser:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.frameLayoutContainer, new AddUserFragment(), null).addToBackStack(null).commit();
                break;
            case R.id.buttonHomeFragmentDisplayUser:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.frameLayoutContainer, new DisplayUserFragment(), null).addToBackStack(null).commit();
                break;
            case R.id.buttonHomeFragmentDeleteUser:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.frameLayoutContainer, new DeleteUserFragment(), null).addToBackStack(null).commit();
                break;
            case R.id.buttonHomeFragmentUpdateUser:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.frameLayoutContainer, new UpdateUserFragment(), null).addToBackStack(null).commit();
                break;
        }
    }
}