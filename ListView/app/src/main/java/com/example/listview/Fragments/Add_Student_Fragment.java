package com.example.listview.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.listview.MainActivity;
import com.example.listview.R;


public class Add_Student_Fragment extends Fragment {

        Button add;
        EditText et_name;
        EditText et_group;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_add__student_, container, false);

        et_name = view.findViewById(R.id.ed_name);
        et_group = view.findViewById(R.id.ed_group);
        add = view.findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getContext()).add_student("" + et_name.getText(), "" + et_group.getText());
                et_name.setText("");
                et_group.setText("");
            }
        });

        return view;
    }
}