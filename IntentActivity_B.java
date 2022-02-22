package com.example.myapp4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class IntentActivity_B extends AppCompatActivity {

    final static String TAG = IntentActivity_B.class.getName(); // "IntentActivity_B";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_b);

        if(getIntent() != null) {
            int getNumbe r = getIntent().getIntExtra("number1", 0);  // 0 nullpointexception을 피하기 위해서 default값 지정 값이 전달이 되지 않을 경우 기본값을 0으로 지정해서 nullpointexception에러를 피해줌
            int getRoomNumber = getIntent().getIntExtra("roomNumber", 0);
            String getStrData = getIntent().getStringExtra("strData");
            // String 데이터 타입으로 값 받기
            Log.d(TAG, "getNumber : " + getNumber);
            Log.d(TAG, "getRoomNumber : " + getRoomNumber); 
            Log.d(TAG, "getStrData : " + getStrData);
        }

        TextView textView = findViewById(R.id.textViewB);
        textView.setOnClickListener(v -> {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("result", 100);

            // 값을 돌려 보낼때
            setResult(Activity.RESULT_OK, resultIntent);

            finish(); // 화면 종료 메서드
        });
        Log.d(TAG, "B : onCreate 호출");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "B : onStart 호출");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "B : onResume 호출");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "B : onPause 호출");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "B : onStop 호출");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "B : onDestroy 호출");
    }
}