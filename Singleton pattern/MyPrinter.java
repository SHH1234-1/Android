package com.example.myfragment.singleton;

public class MyPrinter {

    private static MyPrinter myPrinter;

    // 1. private // new MyPrinter() <-- X (호출 안됨) 외부에서 생성자에 접근하는것을 막음

    public static MyPrinter getInstance() { //외부에서 접근 할 수 있도록 하는 메소드 생성
        if(myPrinter == null) {
            myPrinter = new MyPrinter(); //객체생성
        }

        return myPrinter;
    }

}