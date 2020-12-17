package com.company;

public class Student extends Person {

    private int score;

    public Student(String name, int age, int score) {
        super(name, age);
        this.score = score;

    }

    @Override
    public void printinfo() {
        System.out.println("Ученик");
        super.printinfo();
        System.out.println("баллы - " + score);
    }
}
