package com.example.myapp6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reult);
        Intent intent = getIntent();
        TextView resultTextView = findViewById(R.id.resultTv);

        if(intent != null) {
            int height = intent.getIntExtra("height", 0);
            int weight = intent.getIntExtra("weight", 0);

            // 신장 --> (cm / 100.0) --> m , -> Math
            // m
            // BIM 공식
            // weight / (height * height )
            double bmiValue = weight / Math.pow((height / 100.0),2);
            Log.d("TAG", "bmiValue : " + bmiValue);
            String resultText = "";  //초기화 
            if(bmiValue < 18.5) {
                resultText = "저체중 입니다";
            } else if(bmiValue < 23) {
                resultText = "정상 체중입니다.";
            } else if(bmiValue < 25) {
                resultText = "과체중 입니다";
            } else if(bmiValue < 30) {
                resultText = "경도 비만 입니다";
            } else {
                resultText = "완전 비만 입니다.";
            }

            resultTextView.setText(resultText + "("+ bmiValue +")");
        }
    }
}