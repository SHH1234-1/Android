package com.example.myfragment.builder;

public class Student {

    private String name;
    private int grade;

    private Student() {
    }

    public static class MyBuilder {  //내부클래스

        private String name;
        private int grade;

        public MyBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public MyBuilder setGrade(int grade) {
            this.grade = grade;
            return this;
        }

        // 핵심
        public Student build() {
            Student student = new Student();
            student.name = this.name;
            student.grade = this.grade;
            return student;
        }
    } // 내부 정적 클래스

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' + 
                ", grade=" + grade +
                '}';
    }
}