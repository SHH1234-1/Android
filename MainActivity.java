package com.example.mylottoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private NumberPicker numberPicker;
    private Button addButton;
    private Button initButton;
    private Button runButton;
    private Set<Integer> pickerNumberSet = new HashSet<>();  //set생성
    private ArrayList<TextView> textViews = new ArrayList<>();
    private boolean didRun = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lotto);
        initData();  <!--주소값이 담긴 메소드 호출-->
        addEventListener();
    }

    private void initData() {
        numberPicker = findViewById(R.id.numberPicker);
        numberPicker.setMinValue(1); //numberPicker의 최소값을 1
        numberPicker.setMaxValue(45); //numberPicker의 최대값을 45

        addButton = findViewById(R.id.addButton);  //초기화
        initButton = findViewById(R.id.initButton);
        runButton = findViewById(R.id.runButton);

        textViews.add(findViewById(R.id.textView1));
        textViews.add(findViewById(R.id.textView2));
        textViews.add(findViewById(R.id.textView3));
        textViews.add(findViewById(R.id.textView4));
        textViews.add(findViewById(R.id.textView5));
        textViews.add(findViewById(R.id.textView6));
    }

    private void addEventListener() {
        addButton.setOnClickListener(v -> {

            int selectedNumber = numberPicker.getValue();

            if (didRun) {
                Toast.makeText(this, "초기화 후에 시도해주세요", Toast.LENGTH_SHORT).show();
                return;
            }
            if (pickerNumberSet.size() >= 5) {
                Toast.makeText(this, "번호는 5개까지만 선택 가능합니다.", Toast.LENGTH_SHORT).show();
                return;
            }
            if (pickerNumberSet.contains(selectedNumber)) {
                Toast.makeText(this, "이미 선택한 번호 입니다.", Toast.LENGTH_SHORT).show();
                return;
            }

            TextView textView = textViews.get(pickerNumberSet.size());
            textView.setVisibility(View.VISIBLE);
            textView.setText(String.valueOf(selectedNumber));
            textView.setBackground(setTextViewBackground(selectedNumber));
            pickerNumberSet.add(selectedNumber);
        });

        initButton.setOnClickListener(v -> {
            didRun = false;
            pickerNumberSet.clear();
            for (TextView tv : textViews) {
                tv.setVisibility(View.GONE);
            }
        });

        runButton.setOnClickListener(v -> {

            if (didRun) {
                Toast.makeText(this, "초기화 후에 시도해 주세요",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            List<Integer> list = getRandomNumber();
            list.addAll(pickerNumberSet);
            // 코드 결과 상태 ( 6개 난수가 저장 됨) --> ( list )
            Collections.sort(list);
            Log.d("TAG", list.toString());

            for (int i = 0; i < list.size(); i++) {
                textViews.get(i).setText(String.valueOf(list.get(i))); //
                textViews.get(i).setVisibility(View.VISIBLE);
                textViews.get(i).setBackground(setTextViewBackground(list.get(i)));
            }

            didRun = true;

        });
    }

    private void getRandomNumberTest() {
        // 랜던 숫자를 만들어주는 클래스를 가져온다.
        Random random = new Random();  //난수를 만드는 클래스 Random
        ArrayList<Integer> list = new ArrayList<>();  //번호를 담을 list 생성
        while (list.size() < 6) {   //6개의 번호 선택을 위한 반복문
            int number = random.nextInt(45) + 1;  //random난수의 nextInt(45) 0~44까지 랜덤한 수+1 를 더한 값을 int number에 저장
            if (list.contains(number)) {  //ex 첫번째수가 5 두번째수가 5즉 같은 수를 뽑는 경우는
                continue;  //무시하고 다시 맨위로 보냄
            }
            list.add(number);  //중복수가 아니라면 list에 추가
        }
        Collections.sort(list);  //작은 순서부터 큰 순서로 자동 정렬
        Log.d("TAG", list.toString());  //list가 integer형이므로 String형태로 바꿔서 출력
    }

    private List<Integer> getRandomNumber() {
        ArrayList<Integer> numberList = new ArrayList<>();
 
        // 사용자 선택한 번호 확인
        Log.d("TAG", pickerNumberSet.toString());

        for (int i = 1; i < 46; i++) {

            if (pickerNumberSet.contains(i)) {
                continue;
            }

            numberList.add(i);
        }
        Collections.shuffle(numberList);
        Log.d("TAG", "number List " + numberList.subList(0, 6).toString());
        return numberList.subList(0, (6 - pickerNumberSet.size()));
    }

    private Drawable setTextViewBackground(int number) {
        Drawable drawable;
        // Drawable Resource 가져오는 방법
        // todo 1 ~ 45 까지 색상을 지정해 주세요!!!
        if (number < 11) {
            drawable = ContextCompat.getDrawable(this, R.drawable.round_background_1);
        } else if (number < 21) {
            drawable = ContextCompat.getDrawable(this, R.drawable.round_background_2);
        } else {
            drawable = ContextCompat.getDrawable(this, R.drawable.round_background_1);
        }
        return drawable;
    }


}