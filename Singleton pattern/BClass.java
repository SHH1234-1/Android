package com.example.myfragment.singleton;

public class BClass {

    private MyPrinter myPrinter;

    public BClass() {  //생성자
        myPrinter = MyPrinter.getInstance();
    }

    public MyPrinter getMyPrinter() {
        return this.myPrinter;
    }
} 