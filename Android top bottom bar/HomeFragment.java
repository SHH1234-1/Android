package com.example.mylayout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class HomeFragment extends Fragment {

    private HomeFragment() {
    }
    // 클래스이름.메서드이름
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View homeItemView = inflater.inflate(R.layout.fragment_home, container, false); //fragment_home xml를 메모리에 올림
        // recyclerview
        // adapter
        // manager
        return homeItemView;
    }
}