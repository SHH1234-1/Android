package com.example.myfragment.singleton;

public class MainTest {

    public static void main(String[] args) {

        AClass aClass = new AClass();
        BClass bClass = new BClass();

        System.out.println("인스턴스비교");

        MyPrinter myPrinter1 = aClass.getMyPrinter();
        MyPrinter myPrinter2 = bClass.getMyPrinter();

        System.out.println(myPrinter1.equals(myPrinter2));


    }
}