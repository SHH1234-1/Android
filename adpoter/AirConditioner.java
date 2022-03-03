package com.example.myfragment.adapter;

public class AirConditioner implements Electronic220v {

    @Override
    public void connect() {
        System.out.println("에어콘 연결 됨 ~ 220v On");
    }
}