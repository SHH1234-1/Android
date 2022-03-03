package com.example.myfragment.adapter;

public class HairDryer implements Electronic110v {

    @Override
    public void connect() {
        System.out.println("헤어 드라이기 연결 110v On");
    }
}