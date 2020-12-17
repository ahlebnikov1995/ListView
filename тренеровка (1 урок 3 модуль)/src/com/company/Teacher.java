package com.company;

public class Teacher extends Person {

    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject =  subject;
    }

    @Override
    public void printinfo() {
        System.out.println("Учитель");
        super.printinfo();
        System.out.println("предмет - " + subject);
    }
}
