package com.example.mylistview.model;

import java.io.Serializable;
import java.util.ArrayList;

// Serializable -> 데이터들을 byte 화 시킨다.
public class Food implements Serializable {

    private String thumbnail;
    private String title;
    private String subTitle;
    private String detail;
    private int price;

    public Food(String thumbnail, String title, String subTitle, String detail, int price) {
        this.thumbnail = thumbnail;
        this.title = title;
        this.subTitle = subTitle;
        this.detail = detail;
        this.price = price;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static ArrayList<Food> getData() {
        ArrayList<Food> foods = new ArrayList<>();
        foods.add(new Food("https://cdn.pixabay.com/photo/2014/11/05/15/57/salmon-518032__340.jpg", "Food1", "SubTitle", "detail", 1000));
        foods.add(new Food("https://cdn.pixabay.com/photo/2017/02/15/10/39/salad-2068220__340.jpg", "Food1", "SubTitle", "detail", 1000));
        foods.add(new Food("https://cdn.pixabay.com/photo/2017/06/06/22/46/mediterranean-cuisine-2378758__340.jpg", "Food1", "SubTitle", "detail", 1000));
        foods.add(new Food("https://cdn.pixabay.com/photo/2014/11/05/15/57/salmon-518032__340.jpg", "Food1", "SubTitle", "detail", 1000));
        foods.add(new Food("https://cdn.pixabay.com/photo/2016/03/05/19/02/hamburger-1238246__340.jpg", "Food1", "SubTitle", "detail", 1000));
        foods.add(new Food("https://cdn.pixabay.com/photo/2014/11/05/15/57/salmon-518032__340.jpg", "Food1", "SubTitle", "detail", 1000));
        foods.add(new Food("https://cdn.pixabay.com/photo/2015/12/09/17/11/vegetables-1085063__340.jpg", "Food1", "SubTitle", "detail", 1000));
        foods.add(new Food("https://cdn.pixabay.com/photo/2014/11/05/15/57/salmon-518032__340.jpg", "Food1", "SubTitle", "detail", 1000));
        foods.add(new Food("https://cdn.pixabay.com/photo/2014/11/05/15/57/salmon-518032__340.jpg", "Food1", "SubTitle", "detail", 1000));
        foods.add(new Food("https://cdn.pixabay.com/photo/2014/11/05/15/57/salmon-518032__340.jpg", "Food1", "SubTitle", "detail", 1000));
        foods.add(new Food("https://cdn.pixabay.com/photo/2015/12/09/17/11/vegetables-1085063__340.jpg", "Food1", "SubTitle", "detail", 1000));
        foods.add(new Food("https://cdn.pixabay.com/photo/2014/11/05/15/57/salmon-518032__340.jpg", "Food1", "SubTitle", "detail", 1000));
        foods.add(new Food("https://cdn.pixabay.com/photo/2014/11/05/15/57/salmon-518032__340.jpg", "Food1", "SubTitle", "detail", 1000));
        foods.add(new Food("https://cdn.pixabay.com/photo/2014/11/05/15/57/salmon-518032__340.jpg", "Food1", "SubTitle", "detail", 1000));
        foods.add(new Food("https://cdn.pixabay.com/photo/2015/04/08/13/13/food-712665__340.jpg", "Food1", "SubTitle", "detail", 1000));
        return foods;
    }
}