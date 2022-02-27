package com.example.mysecretdialyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

public class DiaryActivity extends AppCompatActivity {

    EditText diaryEditText;
    Handler handler = new Handler(Looper.getMainLooper());  //데이터를 저장할때 쓰레드를 만들기 위함

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);
 
        SharedPreferences diaryPreferences = getSharedPreferences("diary", Context.MODE_PRIVATE); //activity_diary에 들어왔을때 전에 우리가 입력한 text그대로를 보여주기
        String userText = diaryPreferences.getString("diary", "");

        diaryEditText = findViewById(R.id.diaryEditText);
        diaryEditText.setText(userText);  //activity_diary에 들어왔을때 전에 우리가 입력한 text그대로를 보여주기

        // thread 기능 구현
        Runnable runnable = () -> {  //SharedPreferences를 SharedPreferences.Editor 모드로 만들어 우리가 입력한 text를 입력할때마다 저장하는 것을 thread로 구현
            SharedPreferences preferences = getSharedPreferences("diary", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit(); // 수정모드 우리가 입력한 text를 저장시키기 위한 수정모드
            editor.putString("diary", diaryEditText.getText().toString());  
            editor.apply();  //string형으로 저장
        };


        diaryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable, 500); //사용자가 한글자씩 적는 것은 프로그램적으로 부담이 되기때문에 0.5초후에 따라 쓰래드(저장소에 내가 입력한 text를 저장)를 실행하는 것으로 설정
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
}