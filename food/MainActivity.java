package com.example.mylistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.mylistview.adapter.FoodListAdapter;
import com.example.mylistview.model.Food;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // 리스트 뷰

    /*
    * 1. 리스트로 만들고 싶은 아이템 리스트를 준비한다. (xml, 데이터)
    * 2. 코드상에서 인플레이터를 준비해야 한다. (xml 을 메모리에 올리기 위함)
    * 3. 인플레이터로 아이템 하나의 해당하는 뷰를 만들어 준다.
    * 4. 위에서 만든 뷰를 컨테이너 뷰에 붙여준다.
    *
    * : 어댑터 를 이용한다.
    *
    * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 데이터
        // 샘플 데이터 가져오기
        ArrayList<Food> foods = Food.getData();
        FoodListAdapter foodListAdapter = new FoodListAdapter(foods, this);
        ListView listView = findViewById(R.id.foodListView);
        listView.setAdapter(foodListAdapter);


        // 리스트 뷰에서 이벤트 리스너 사용방법
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("TAG", "selected Id : " + position);

                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra("serialOBJ", foods.get(position));  //gets(int)인데 position은 객체임으로 객체를 byte화 시켜서 넘겨주기 위해서 Serializable시킨다
                startActivity(intent); 
            }
        });

    }
}