package com.example.myrecyclerview.observer;

public class MainTest {

    public static void main(String[] args) {

        Button myButton = new Button("우리가만든 버튼");
        myButton.addListener(new IButtonListener() {  //인터페이스는 객체 생성이 불가능 함으로 익명함수생성
            @Override
            public void clickEvent(String event) {
                System.out.println("동작을 확인 합니다 !!! " + event);
            }
        });

        myButton.click("안녕하세요~~~~");
        myButton.click("hi");
        myButton.click("Hello");
        myButton.click("abcd");
    }
}