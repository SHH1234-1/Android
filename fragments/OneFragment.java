package com.example.myfragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class OneFragment extends Fragment {

    @Override
    public void onAttach(@NonNull Context context) {
        Log.d("TAG" , "Fragment : onAttach ~" );
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("TAG" , "Fragment : onCreate ~" );
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("TAG" , "Fragment : onCreateView ~" );

        View view = inflater.inflate(R.layout.fragment_one, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d("TAG" , "Fragment : onViewCreated ~" );

        if(getArguments() != null) {
            String data = getArguments().getString("param1", "");
            Log.d("TAG", "data :" + data);

            AlertDialog.Builder builder = new AlertDialog.Builder(getContext()); //getContext  OneFragment의 부모객체
            builder.setTitle("알림")
                    .setMessage("넘겨 받은 데이터 " + data)
                    .setPositiveButton("확인", new DialogInterface.OnClickListener() {  //버튼생성
                        @Override
                        public void onClick(DialogInterface dialog, int which) {  //버튼을 클릭했을때
                            // 아무 동작 안함
                        }
                    }).setNegativeButton("취소", (dialog, which) -> {  //람다식
                        // 아무 동작 안함
            });

            builder.show();
        }

        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public void onStart() {
        Log.d("TAG" , "Fragment : onStart ~" );
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d("TAG" , "Fragment : onResume ~" );
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d("TAG" , "Fragment : onPause ~" );
        super.onPause();
    }

    @Override
    public void onDestroyView() {

        Log.d("TAG" , "Fragment : onDestroyView ~" );
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d("TAG" , "Fragment : onDestroy ~" );
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d("TAG" , "Fragment : onDetach ~" );
        super.onDetach();
    }

}