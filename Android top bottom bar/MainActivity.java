package com.example.mylayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    BottomNavigationView bottomNavigationView;
    LinearLayout mainContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        setSupportActionBar(toolbar); //앱에 기본적으로 ActionBar를 올려주되 그 액션바는 (toolbar); 우리가 만들었던 (toolbar)를 사용
        addListenerBottomView();
        replaceFragment(HomeFragment.newInstance()); //첫화면 설정
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.top_app_bar, menu); //(R.menu.top_app_bar xml을 메모리에 올리기
        return true;  //true false면 동작하지 않음
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.favorite:
                // todo new Activity 만들어서 보내기 !!!
                Log.d("TAG", "favorite !!!");
                break;
            case R.id.search:
                Log.d("TAG", "search !!!");
                break;
            case R.id.more:
                Log.d("TAG", "more !!!");
                break;
        }
        return true;  //사용 false면 동작하지 않음
    }

    private void initData() {
        toolbar = findViewById(R.id.topAppBar);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        mainContainer = findViewById(R.id.mainContainer);
    }

    private void replaceFragment(Fragment fragment) {
        //  프래그먼트를 동적으로 만들기 위해 필요한 준비.
        // 1. 프래그먼트 매니저를 가져오기 (프래그먼트 트랜잭션을 시작할 수 있다)
        FragmentManager fragmentManager = getSupportFragmentManager();
        // 2. 프래그먼트 트랜잭션을 (작업에 단위)
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // 3. replace, commit
        fragmentTransaction.replace(R.id.mainContainer, fragment);
        fragmentTransaction.commit();
    }

    private void addListenerBottomView() {
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() { //아이템이 선택이 되었을때 콜백함수 호출
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.page_1:
                        replaceFragment(HomeFragment.newInstance());
                        break;
                    case R.id.page_2:
                        replaceFragment(PersonFragment.newInstance());
                        break;
                    case R.id.page_3:
                        replaceFragment(ChatFragment.newInstance());
                        break;
                    case R.id.page_4:
                        replaceFragment(ViewFragment.newInstance());
                        break;
                }
                return true;
            }
        });
    }
}