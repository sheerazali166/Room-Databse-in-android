package com.example.roomdatabaseexample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class UpdateUserFragment extends Fragment {

    EditText editTextUpdateUserId, editTextUpdateUserName, editTextUpdateUserEmail;
    Button buttonUpdateUserUpdateRecord;

    public UpdateUserFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_user, container, false);

        editTextUpdateUserId = view.findViewById(R.id.editTextUpdateUserId);
        editTextUpdateUserName = view.findViewById(R.id.editTextUpdateUserName);
        editTextUpdateUserEmail = view.findViewById(R.id.editTextUpdateUserEmail);

        buttonUpdateUserUpdateRecord = view.findViewById(R.id.buttonUpdateUserUpdateRecord);

        buttonUpdateUserUpdateRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = Integer.parseInt(editTextUpdateUserId.getText().toString());
                String name = editTextUpdateUserName.getText().toString();
                String email = editTextUpdateUserEmail.getText().toString();

                User user = new User();
                user.setId(id);
                user.setName(name);
                user.setEmail(email);

                MainActivity.myRoomDatabase.myDao().UpdateUser(user);

                Toast.makeText(getActivity(), "Record successfully updated.", Toast.LENGTH_SHORT).show();

                editTextUpdateUserId.setText("");
                editTextUpdateUserName.setText("");
                editTextUpdateUserEmail.setText("");
            }
        });

        return view;
    }
}