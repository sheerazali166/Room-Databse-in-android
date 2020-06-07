package com.example.roomdatabaseexample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AddUserFragment extends Fragment {


    EditText editTextAddUserId, editTextAddUserName, editTextAddUserEmail;
    Button buttonAddUserSaveRecords;


    public AddUserFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);

        editTextAddUserId = view.findViewById(R.id.editTextAddUserId);
        editTextAddUserName = view.findViewById(R.id.editTextAddUserName);
        editTextAddUserEmail = view.findViewById(R.id.editTextAddUserEmail);

        buttonAddUserSaveRecords = view.findViewById(R.id.buttonAddUserSaveRecord);

        buttonAddUserSaveRecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = Integer.parseInt(editTextAddUserId.getText().toString());
                String name = editTextAddUserName.getText().toString();
                String email = editTextAddUserEmail.getText().toString();

                User user = new User();
                user.setId(id);
                user.setName(name);
                user.setEmail(email);

                MainActivity.myRoomDatabase.myDao().AddUser(user);

                Toast.makeText(getActivity(), "Records successfully added into the database.", Toast.LENGTH_SHORT).show();

                editTextAddUserId.setText("");
                editTextAddUserName.setText("");
                editTextAddUserEmail.setText("");
            }
        });

        return view;
    }
}