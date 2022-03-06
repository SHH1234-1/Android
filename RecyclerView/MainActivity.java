package com.example.myrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import com.example.myrecyclerview.adapter.FoodListAdapter;
import com.example.myrecyclerview.models.Food;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // 준비물
    // 샘플 데이터 (통신) Food.java
    // 어댑터  FoodListAdapter.java
    // 레이아웃 매니져 MainActivity.java

    /*
    *
    * RecyclerView
    *  - 장점
    *  - ListView 개선판
    *     - ViewHolder (강제)
    * - 유연하다
    *  - LayoutManager (수평으로 리스트를 만들기 쉽다)
    *   - Linear
    *   - Grid
    *   - StaggeredGrid
    *
    * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Food> foods = Food.getData();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        FoodListAdapter adapter = new FoodListAdapter(foods, this); //context this 
        recyclerView.setAdapter(adapter);  //apapter에서 recyclerView로 넣어주기

        // 레이아웃 매니저 생성
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
//        recyclerView.setLayoutManager(gridLayoutManager);

        // divider 생성해보기
//        DividerItemDecoration dividerItemDecoration
//                = new DividerItemDecoration(this, linearLayoutManager.getOrientation());
//        recyclerView.addItemDecoration(dividerItemDecoration);

    }
}