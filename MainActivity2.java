package com.example.myapp4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {

    // 변수 :  태그 하나 더만들기 (태그 필터 새성)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2); //MainActivity2를 메모리에 올릴때 R.layout.activity_main2디자인을 같이 메모리에 올리는것
    }

    // Life cycle 메서드 오버라이드 해보기 :
}