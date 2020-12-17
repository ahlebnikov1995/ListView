package com.company;

public class Main {

    public static void main(String[] args) {



        Student artem = new Student("Артём",17,1000);
        Student slava = new Student("Слава",17,0);
        Student ilya = new Student("Илюша",17,0);
        Student anya = new Student("Аня",15,0);
        Student nikita = new Student("Никита(не путать с Сашкой)",18,0);
        Student sashka = new Student("Сашка(не путать с Никитой)",18,0);

        Student[] students = {artem, slava, ilya, anya, nikita, sashka};

        Teacher new_emenem = new Teacher("Новый эменем", 26, "мобильная разработка");

        Group mr3 = new Group("мр 3",students, new_emenem);

        mr3.print();

        }
        }
