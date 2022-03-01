package com.example.myfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button createFragmentButton;
    Button removeFragmentButton;
    OneFragment oneFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("TAG", "Activity : onCreate ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createFragmentButton = findViewById(R.id.createFragmentButton);
        removeFragmentButton = findViewById(R.id.removeFragmentButton);
        oneFragment = new OneFragment();  //OneFragment 객체생성

        // 데이터를 전달하는 방법
        Bundle bundle = new Bundle();
        bundle.putString("param1", "안녕하세요");
        oneFragment.setArguments(bundle);


        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        createFragmentButton.setOnClickListener(v -> {
            // 자바 코드로 프래그먼트를 생성하는 방법
            //oneFragment = new OneFragment();
            // 1. FragmentManager ( 프래그먼트 트랜잭션을 객체를 가져올 수 있다)
            // 2. FragmentTransaction -> 작업의 단위( 시작과 끝이 있다)
            //FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            // replace / add
            fragmentTransaction.replace(R.id.fragmentContainer, oneFragment);
            fragmentTransaction.commit();
            // commit() : 시간될 때 완료해
            // commitNow()  : 지금 당장해 !!!
            // commitAllowingStateLoss() <--- 위험 (커밋이 없어질 수 있다)
        });

        removeFragmentButton.setOnClickListener(v -> {
            // 자바코드로 프래그먼트 제거 하기
            // remove, detach
            // remove : 인스턴스를 다시 연결할 수 없다. : 프래그먼트 트랜잭션에 다시 추가해야 한다.
//            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(oneFragment);
            fragmentTransaction.commit();
        });

    }

    @Override
    protected void onStart() {
        Log.d("TAG", "Activity : onStart ");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d("TAG", "Activity : onResume ");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("TAG", "Activity : onPause ");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("TAG", "Activity : onStop ");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("TAG", "Activity : onDestroy ");
        super.onDestroy();
    }

}