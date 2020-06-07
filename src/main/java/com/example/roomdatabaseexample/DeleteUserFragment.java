package com.example.roomdatabaseexample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteUserFragment extends Fragment {

    EditText editTextDeleteUserId;
    Button buttonDeleteUserDeleteRecord;

    public DeleteUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_delete_user, container, false);

        editTextDeleteUserId = view.findViewById(R.id.editTextDeleteUserId);
        buttonDeleteUserDeleteRecord = view.findViewById(R.id.buttonDeleteUserDeleteRecord);

        buttonDeleteUserDeleteRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = Integer.parseInt(editTextDeleteUserId.getText().toString());

                User user = new User();
                user.setId(id);

                MainActivity.myRoomDatabase.myDao().DeleteUser(user);

                Toast.makeText(getActivity(), "Record successfully deleted.", Toast.LENGTH_SHORT).show();

                editTextDeleteUserId.setText("");

            }
        });

        return view;
    }
}