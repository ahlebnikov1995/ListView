package com.example.listview;

public class Student {
    private String name;
    private String group;
    private int score;

    public Student(String name, String group) {
        this.name = name;
        this.group = group;
        this.score = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getScore() {
        return score;
    }
}
