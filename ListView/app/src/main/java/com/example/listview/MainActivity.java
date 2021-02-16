package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Fragments.Add_Student_Fragment;
import Fragments.Change_Student_Fragment;

public class MainActivity extends AppCompatActivity {

    public static final String BUNDLE_NAME = "msg";
    public static final String BUNDLE_NAME2 = "msg 2";

    FragmentTransaction transaction;
    Add_Student_Fragment add_student_fragment;
    Change_Student_Fragment change_student_fragment;

    ArrayList<Student> students;
    ListView lv_students;
    StudentAdapter adapter;

    Button addStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_students = findViewById(R.id.lv_Students);
        students = new ArrayList<>();

        add_student_fragment = new Add_Student_Fragment();
        change_student_fragment = new Change_Student_Fragment();


        adapter = new StudentAdapter(this, students);
        lv_students.setAdapter(adapter);

        addStudent = findViewById(R.id.addStudent);
        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.ll_main,add_student_fragment);
            transaction.commit();
            }
        });

        lv_students.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putSerializable(BUNDLE_NAME, position);
                change_student_fragment.setArguments(bundle);

                transaction = getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.ll_main,change_student_fragment);
                transaction.commit();
            }
        });

    }

    public void add_student(String name, String group){
        students.add(new Student(name,group));
        adapter.notifyDataSetChanged();
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.remove(add_student_fragment);
        transaction.commit();

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getScore() - o1.getScore();
            }
        });

    }

    public void change_student(int position, int score){
        students.get(position).setScore(score);
        adapter.notifyDataSetChanged();
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.remove(change_student_fragment);
        transaction.commit();

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getScore() - o1.getScore();
            }
        });
    }


}