package Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.listview.MainActivity;
import com.example.listview.R;
import com.example.listview.Student;

import java.util.ArrayList;


public class Change_Student_Fragment extends Fragment {

    EditText etScore;
    Button change;
    Integer position;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_change__student_, container, false);

        position = (Integer) (getArguments().getSerializable(MainActivity.BUNDLE_NAME));


        etScore = view.findViewById(R.id.et_score);
        change = view.findViewById(R.id.change);

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score = Integer.parseInt(etScore.getText().toString());
                ((MainActivity) getContext()).change_student(position, score);
                etScore.setText("");
            }
        });

        return view;
    }
}