package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentAdapter extends ArrayAdapter<Student> {

    public StudentAdapter(@NonNull Context context, ArrayList<Student> students) {
        super(context, R.layout.student_item, students);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.student_item, null);
        }



        ((TextView) convertView.findViewById(R.id.tv_name)).setText("Имя: " + getItem(position).getName());
        ((TextView) convertView.findViewById(R.id.tv_group)).setText("Группа: " + getItem(position).getGroup());
        ((TextView) convertView.findViewById(R.id.tv_score)).setText("Баллы: " + String.valueOf(getItem(position).getScore()));



        return convertView;
    }
}
