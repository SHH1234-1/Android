package com.example.myviewpager.adapter;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager; 
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.myviewpager.OneFragment;
import com.example.myviewpager.ThreeFragment;
import com.example.myviewpager.TwoFragment;

public class PagerAdapter extends FragmentPagerAdapter {

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        switch (position) {
            case 0:
                Log.d("TAG", "Fragment 0");
                fragment = new OneFragment();
                break;
            case 1:
                Log.d("TAG", "Fragment 1");
                fragment = new TwoFragment();
                break;
            case 2:
                Log.d("TAG", "Fragment 2");
                fragment = new ThreeFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}