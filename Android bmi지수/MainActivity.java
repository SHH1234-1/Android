package com.example.myapp6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();  //MainActivity


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText heightEt = findViewById(R.id.heightEt);  //<!--신장-->
        EditText weightEt = findViewById(R.id.weightEt);  //<!--체중-->
        Button btnOk = findViewById(R.id.btn_ok);    //<!--확인하기-->

        // 이벤트 리스너 등록
        btnOk.setOnClickListene  r(v -> {
            // 값 --> String --> int
//            String height = heightEt.getText().toString();
            String height = heightEt.getText().toString();
            String weight = weightEt.getText().toString();
            if (height.length() < 1 || weight.length() < 1) {  //아무런 값을 입력받지 않을 경우
                Toast.makeText(this, "빈 값이 있습니다.", Toast.LENGTH_SHORT).show(); //빈값이 있습니다 출력
            } else {
              // 목표 다른 화면으로 값을 전송
                Intent intent = new Intent(this, ResultActivity.class);  //<!--값을 보내줄 다른 activity-->
                intent.putExtra("height", Integer.parseInt(height));  //값을 보내줌
                intent.putExtra("weight", Integer.parseInt(weight));  //값을보내줌
                startActivity(intent);
            }

        });


    }
}