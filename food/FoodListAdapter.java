package com.example.mylistview.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mylistview.R;
import com.example.mylistview.model.Food;

import java.util.ArrayList;

public class FoodListAdapter extends BaseAdapter {

    ArrayList<Food> data;
    Context context;

    public FoodListAdapter(ArrayList<Food> data, Context context) {
        this.data = data;
        this.context = context; 
    }

    /* 전체 갯수를 알아야 adapter 가 조정할 수 있다. */
    @Override
    public int getCount() {
        return data.size();
    }

    /* 데이터 하나을 알려준다. */
    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    /* 목록의 각 행에 대한 고유한 ID를 정의하는 메소드를 구현합니다.*/
    @Override
    public long getItemId(int position) {
        return position;
    }


//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        LayoutInflater inflater = LayoutInflater.from(context);
//        View itemView = inflater.inflate(R.layout.item_food, null); //item_food를 메모리에 올린다
//
//        ImageView imageView = itemView.findViewById(R.id.thumbnailImageview);  //item_food xml 안에있는 id값을 전부 다 가져온다
//        TextView titleTextView = itemView.findViewById(R.id.titleTextView);
//        TextView subTitleTextView = itemView.findViewById(R.id.subTitleTextView);
//        TextView detailTextView = itemView.findViewById(R.id.detailTextView);
//
//        Food food = data.get(position);   우리가 만들어놓았던 하나의 객체 정보를 가져온다
//
//        Glide.with(context) 
//                .load(food.getThumbnail())
//                .centerCrop()
//                .into(imageView); 
//
//        titleTextView.setText(food.getTitle());  //값을 가져와서 mxl에 돌려줌
//        subTitleTextView.setText(food.getSubTitle());
//        detailTextView.setText(food.getDetail());
//
//        Log.d("TAG", "getView 호출 :" + position);
//
//        return itemView;
//    }

    // 뷰홀더 개념을 이용해서 성능개선
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View itemView;
        FoodListViewHolder holder;
        // convertView 가 한번도 만들어 지지 않았다면
        if(convertView == null) {
            holder = new FoodListViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            itemView = inflater.inflate(R.layout.item_food, null);
            holder.imageView = itemView.findViewById(R.id.thumbnailImageview);
            holder.titleTextView = itemView.findViewById(R.id.titleTextView);
            holder.subTitleTextView = itemView.findViewById(R.id.subTitleTextView);
            holder.detailTextView = itemView.findViewById(R.id.detailTextView);
            // 중요 ~
            // 찾을 수 있도록 태그를 달아 놓는다.
            itemView.setTag(holder);
        } else {
            holder = (FoodListViewHolder) convertView.getTag();
            itemView = convertView;
        }

        Food food = data.get(position);

        Glide.with(context)
                .load(food.getThumbnail())
                .centerCrop()
                .into(holder.imageView);

        holder.titleTextView.setText(food.getTitle());
        holder.subTitleTextView.setText(food.getSubTitle());
        holder.detailTextView.setText(food.getDetail());

        return itemView;
    }
}