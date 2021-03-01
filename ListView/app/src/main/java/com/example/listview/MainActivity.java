package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.example.listview.Fragments.Add_Student_Fragment;
import com.example.listview.Fragments.Change_Student_Fragment;
import com.example.listview.db.StudentDbHelper;

public class MainActivity extends AppCompatActivity {

    public static final String BUNDLE_NAME = "msg";
    public static final String BUNDLE_NAME2 = "msg 2";

    FragmentTransaction transaction;
    Add_Student_Fragment add_student_fragment;
    Change_Student_Fragment change_student_fragment;

    ArrayList<Student> students;
    ListView lv_students;
    StudentDbHelper dbHelper;
    StudentAdapter adapter;

    Button addStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new StudentDbHelper(this);

        lv_students = findViewById(R.id.lv_Students);
        students = dbHelper.getStudents();

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
        dbHelper.addStudent(new Student(null, name, group, 0));
        students.clear();
        students.addAll(dbHelper.getStudents());
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
        dbHelper.changeStudent( new Student(students.get(position).getId(), students.get(position).getName(), students.get(position).getGroup(), score));
        students.clear();
        students.addAll(dbHelper.getStudents());

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

    public void delete_student(int position){
        dbHelper.deleteStudent(students.get(position));
        students.clear();
        students.addAll(dbHelper.getStudents());

        transaction = getSupportFragmentManager().beginTransaction();
        transaction.remove(change_student_fragment);
        transaction.commit();
    }

    @Override
    protected void onDestroy() {
        dbHelper.close();
        super.onDestroy();
    }
}