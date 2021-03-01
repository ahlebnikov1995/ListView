package com.example.listview;

public class Student {
    private Integer id;
    private String name;
    private String group;
    private int score;

    public Student(Integer id, String name, String group, int score) {
        this.id = id;
        this.name = name;
        this.group = group;
        this.score = score;
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

    public Integer getId() {
        return id;
    }
}
