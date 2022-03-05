package com.example.myfragment.builder;

public class MainTest {

    public static void main(String[] args) {
        Student student = new Student.MyBuilder()
                .setName("홍길동")
                .setGrade(3)
                .build();

        Student student1 = new Student.MyBuilder().setName("이순신").setGrade(1).build();

        System.out.println(student.toString());
        System.out.println(student1.toString());
    }
}