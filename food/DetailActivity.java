package com.example.mylistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mylistview.model.Food;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if (getIntent() != null) {
            // 역직렬화(Deserialization)
            // 직렬화한 데이터를 본래의 객체로 되돌리는 작업을 역직렬화라고 한다.
            Food food = (Food) getIntent().getSerializableExtra("serialOBJ");
            Log.d("TAG", food.getThumbnail());
            Log.d("TAG", food.getTitle());
            Log.d("TAG", food.getSubTitle());
            Log.d("TAG", food.getDetail());

            ImageView imageView = findViewById(R.id.thumbnailImageview);
            TextView titleTextView = findViewById(R.id.titleTextView);
            TextView subTitleTextView = findViewById(R.id.subTitleTextView);
            TextView priceTextView = findViewById(R.id.priceTextView);


            Glide.with(this)
                    .load(food.getThumbnail())
                    .centerCrop()
                    .into(imageView);

            titleTextView.setText(food.getTitle());
            subTitleTextView.setText(food.getSubTitle());
            priceTextView.setText(String.valueOf(food.getPrice()) + " 원");


        }

    }
}