package com.company;

public class Group {
    private String name;
    private Student[] students;
    private Teacher teacher;

    public Group(String name, Student[] students, Teacher teacher) {
        this.name = name;
        this.students = students;
        this.teacher = teacher;
    }
    public void print(){
        System.out.println(name);
        System.out.println();
        teacher.printinfo();
        for (int i = 0; i < students.length; i++) {
            System.out.println();
            students[i].printinfo();

        }
    }

}
