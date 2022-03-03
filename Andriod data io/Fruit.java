package com.example.myaddview;

import java.util.ArrayList;

// https://cdn.pixabay.com/photo/2017/05/11/19/44/fresh-fruits-2305192__340.jpg
// https://cdn.pixabay.com/photo/2021/07/30/04/17/orange-6508617__340.jpg
// https://cdn.pixabay.com/photo/2016/04/15/08/04/strawberry-1330459__340.jpg
// https://cdn.pixabay.com/photo/2014/12/21/23/39/bananas-575773__340.png
// https://cdn.pixabay.com/photo/2015/12/30/11/57/fruits-1114060__340.jpg
// https://cdn.pixabay.com/photo/2018/05/08/20/19/pomegranate-3383814__340.jpg
// https://cdn.pixabay.com/photo/2016/10/07/13/36/tangerines-1721590__340.jpg
// https://cdn.pixabay.com/photo/2017/01/31/09/30/raspberries-2023404__340.jpg


public class Fruit {

    String imageUrl;
    String name;
    String count;
    String price;

    public Fruit(String imageUrl, String name, String count, String pri ce) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.count = count;
        this.price = price;
    }

    // 샘플 데이터
    public static ArrayList<Fruit> getFruits() {
        ArrayList<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit("https://cdn.pixabay.com/photo/2010/12/13/10/05/berries-2277__480.jpg",
                "레몬", "10", "5_000원"));
        fruits.add(new Fruit("https://cdn.pixabay.com/photo/2021/07/30/04/17/orange-6508617__340.jpg",
                "사과", "12", "1_000원"));
        fruits.add(new Fruit("https://cdn.pixabay.com/photo/2017/05/11/19/44/fresh-fruits-2305192__340.jpg",
                "딸기", "5", "2_000원"));
        fruits.add(new Fruit("https://cdn.pixabay.com/photo/2016/04/15/08/04/strawberry-1330459__340.jpg",
                "귤", "101", "7_000원"));
        fruits.add(new Fruit("https://cdn.pixabay.com/photo/2014/12/21/23/39/bananas-575773__340.png",
                "배", "110", "9_000원"));
        fruits.add(new Fruit("https://cdn.pixabay.com/photo/2017/05/11/19/44/fresh-fruits-2305192__340.jpg",
                "포도", "1", "11_000원"));
        fruits.add(new Fruit("https://cdn.pixabay.com/photo/2016/10/07/13/36/tangerines-1721590__340.jpg",
                "설향", "7", "55_000원"));
        fruits.add(new Fruit("https://cdn.pixabay.com/photo/2017/01/31/09/30/raspberries-2023404__340.jpg",
                "수박", "30", "12_000원"));
        return fruits;
    }

}