package com.example.myaddview;

import static com.example.myaddview.Fruit.getFruits;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Fruit> sampleData = getFruits();

        // 준비물
        // 1. 뷰를 위치시킬 컨테이너 가져오기
        LinearLayout container = findViewById(R.id.fruitContainer);
        // 2.xml 파일을 메모리에 올리는 방법
        LayoutInflater inflater = LayoutInflater.from(this);

        sampleData.forEach(fruit -> {
            View itemView = inflater.inflate(R.layout.item_food, container, false);

            ImageView fruitImageView = itemView.findViewById(R.id.fruitImageView);
            TextView fruitName = itemView.findViewById(R.id.fruitName);
            TextView fruitCount = itemView.findViewById(R.id.fruitCount);
            TextView fruitPrice = itemView.findViewById(R.id.fruitPrice); 

            //
            //fruitImageView.setBackgroundColor(Color.BLACK);
            Log.d("TAG", "fruit.imageUrl :" + fruit.imageUrl);
//            Glide.with(this)
//                    .load(fruit.imageUrl)
//                    .centerCrop()     //이미지 뷰영역에 자동으로 맞추기
//                    .into(fruitImageView);

            Glide.with(this)
                    .load(fruit.imageUrl)
                    .apply(new RequestOptions().circleCrop())
                    .into(fruitImageView);
 


            fruitName.setText(fruit.name);
            fruitCount.setText(fruit.count);
            fruitPrice.setText(fruit.price);
            container.addView(itemView);
        });
    }
}
