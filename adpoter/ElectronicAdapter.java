package com.example.myfragment.adapter;

public class ElectronicAdapter implements Electronic220v {

    Electronic110v electronic110v;

    public ElectronicAdapter(Electronic110v electronic110v) {
        this.electronic110v = electronic110v;
    }

    @Override
    public void connect() {
        electronic110v.connect();
    }
}