package com.example.myretrofit2_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myretrofit2_v2.models.request.ReqPost;
import com.example.myretrofit2_v2.models.response.ResPost;
import com.example.myretrofit2_v2.repository.PostService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Retrofit retrofit;
    private PostService service;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        addEventListener();
    }

    private void addEventListener() {
        button1.setOnClickListener(v -> {
             // getPost
            requestPost();
        });
        button2.setOnClickListener(v -> {
            // createPost
            savePost();
        });
        button3.setOnClickListener(v -> {
            updatePost();
        });
        button4.setOnClickListener(v -> {
            deletePost();
        });
    }

    private void deletePost() {
        service.deletePost(3).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.d(TAG, "상태코드 : " + response.code());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

    private void updatePost() {
        // putPost
        ReqPost requestPost = new ReqPost(100, "수정 타이틀", "수정 내용", 3);
        service.putPost(3, requestPost).enqueue(new Callback<ResPost>() {
            @Override
            public void onResponse(Call<ResPost> call, Response<ResPost> response) {
                Log.d(TAG, "상태 코드 " + response.code());
                Log.d(TAG, "message : " + response.message());
                if (response.isSuccessful()) {
                    ResPost resPost = response.body();
                    Log.d(TAG, "응답결과 : " + resPost.toString());
                }
            }

            @Override
            public void onFailure(Call<ResPost> call, Throwable t) {

            }
        });
    }



    private void savePost() {
        service.createPost(new ReqPost("타이틀", "내용", 3)).enqueue(new Callback<ResPost>() {
            @Override
            public void onResponse(Call<ResPost> call, Response<ResPost> response) {
                Log.d(TAG, "코드 : " + response.code());
                if (response.isSuccessful()) {
                    Log.d(TAG, "응답 결과 : " + response.body());
                    ResPost result = response.body();
                    Log.d(TAG, "result : " + result.getTitle());
                }
            }

            @Override
            public void onFailure(Call<ResPost> call, Throwable t) {

            }
        });
    }

    private void requestPost() {
        service.getPost(10).enqueue(new Callback<ResPost>() {
            @Override
            public void onResponse(Call<ResPost> call, Response<ResPost> response) {
                // 성공
                Log.d(TAG, "상태코드 : " + response.code());
                Log.d(TAG, "메세지 : " + response.message());
                Log.d(TAG, "응답 헤더 : " + response.headers());

                if (response.isSuccessful()) {
                    Log.d(TAG, "응답 결과 : " + response.body());
                    ResPost result = response.body();
                    Log.d(TAG, "result : " + result.getTitle());

                    textView.setText(result.getTitle());
                    textView.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<ResPost> call, Throwable t) {
                Log.d(TAG, t.getMessage() + "  < --- 실패 ");
            }
        });
    }

    private void initData() {
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        textView = findViewById(R.id.postTitleTextView);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(PostService.class);

    }
    
}