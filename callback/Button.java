package com.example.myrecyclerview.observer;

public class Button {

    private String name;
    private IButtonListener iButtonListener;

    public Button(String name) {  //생성자
        this.name = name; 
    }

    public void click(String message) { //메서드
        iButtonListener.clickEvent(message);
    }

    public void addListener(IButtonListener listener) { //null point exception 방지용
        this.iButtonListener = listener;
    }

}