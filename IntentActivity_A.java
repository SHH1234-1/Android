package com.example.myapp4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class IntentActivity_A extends AppCompatActivity {

    final static String TAG = IntentActivity_A.class.getName(); // "IntentActivity_A"

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_activity);
        Log.d(TAG, "A: onCreate ~");
        Button button = findViewById(R.id.buttonA); 
//        button.setOnClickListener(v -> {
//            // B 라는 화면을 보여줘 --> OS
//            // 1.명시적 인텐트
//            Intent intent1 = new Intent(this, IntentActivity_B.class);
//            // 1.1 인텐트 값 보내는 방법
//            intent1.putExtra("number1", 1);
//            intent1.putExtra("roomNumber", 2);
//            intent1.putExtra("strData", "안녕하세요~");
//            // String 값 보내기 연습
//            startActivity(intent1);
//
//            // 2.암시적 인텐트
////            Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));  
////            startActivity(intent2);
//        });

        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, IntentActivity_B.class);
            // 값을 안보냄.
            //startActivity(intent);
            startActivityForResult(intent, 10001);
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, requestCode + "");
        Log.d(TAG, resultCode + "");
        Log.d(TAG, data + "");
        if(resultCode == RESULT_OK) {
            int resultData = data.getIntExtra("result", 0);
            Log.d(TAG, "resultData :" + resultData);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "A: onStart ~");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "A: onResume ~");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "A: onPause ~");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "A: onStop ~");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "A: onDestroy ~");
    }
}