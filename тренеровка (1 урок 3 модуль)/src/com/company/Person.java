package com.company;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void printinfo() {
        System.out.println("Имя - " + name);
        System.out.println("Возраст - " + age);

    }
}
