package com.example.myhttpconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.myhttpconnection.models.Person;
import com.example.myhttpconnection.models.User;
import com.example.myhttpconnection.models.response.ResTodo;
import com.example.myhttpconnection.service.UserService;
import com.example.myhttpconnection.utils.HttpClient;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "TAG";
    ArrayList<Person> personArrayList;
    ArrayList<ResTodo> todos;
    TextView textView;
    HttpClient httpClient;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserService userService = new UserService();
        user = userService.read("10");

    }



    private void requestTodos() {
        new Thread(() -> {
            try {
                todos = httpClient.todos("/todos");
                Log.d(TAG, "todos : " + todos.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

    }

    private void savePost() {
        new Thread(() -> {
            try {
                httpClient.posts("/posts");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }


    /**
     * JSON Object
     * JSON Array
     */
    private void testCodeForJson() {
        // 1. ????????? jsonObject ?????????
        // 2. JSON Array ?????????

        // JSON Object ????????? ????????? ?????? ??????
        // { key : value }
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        try {
            jsonObject.put("??????", "?????????");
            jsonObject.put("??????", 30);
            jsonObject.put("??????", "?????????");
            jsonObject.put("??????", "??????");
            jsonObject.put("????????????", false);


            jsonArray.put(jsonObject);
            jsonArray.put(jsonObject);
            jsonArray.put(jsonObject);
//            Log.d(TAG, jsonArray.toString());


            // ????????? ??????
            // 1. JSON OBJECT ?????? ??????
//            Log.d(TAG, jsonObject.toString());
//            Person person = new Gson().fromJson(jsonObject.toString(), Person.class);
//            Log.d(TAG, person.get??????());
//            Log.d(TAG, person.get??????() + "");

            // 2. JSON Array ?????? ?????? !
//            Person[] people = new Gson().fromJson(jsonArray.toString(), Person[].class);
//            Log.d(TAG, Arrays.toString(people));

            // 3. ArrayList ??? ???????????? ??????
            Type listType = new TypeToken<ArrayList<Person>>(){}.getType();
            personArrayList = new Gson().fromJson(jsonArray.toString(), listType);
            Log.d(TAG, personArrayList.get(0).toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



    /**
     * ??????, ?????????????????? ????????????????????? ????????????
     * ???????????? ???????????? ???????????? ?????? (HTTP)
     */
    private void httpConnectionTestCode() {

        // ?????????????????? ????????? ?????????
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 1. ????????? URL ?????? ??????
                String baseUrl = "https://jsonplaceholder.typicode.com/";
                String endPoint = "todos/1";
                try {
                    // Http Request Message ?????? (????????? + http header)
                    URL url = new URL(baseUrl + endPoint);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET"); // GET, POST, PUT, DELETE

                    // ????????? ??????
                    // 1. ?????? ?????? ??????
                    // ???????????? 1xx(?????????), 2xx(??????), 3xx(????????????), 4xx(??????: ???????????????), 500(????????????)
                    // GET ?????? ---> 200 ??????
                    // POST ?????? ---> 201 ??????
                    Log.d("TAG", "???????????? ?????? ?????? " + conn.getResponseCode());

                    // ?????? ?????? ????????? ?????? ??????
                    if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                        BufferedReader reader = new BufferedReader(
                                new InputStreamReader(conn.getInputStream())
                        );

                        // Dto
                        ResTodo todo = new Gson().fromJson(reader, ResTodo.class);
                        Log.d(TAG, todo.toString()); // -> ????????? :: --> ??????????????? ??????
                        Log.d(TAG, todo.getTitle());
                        Log.d(TAG, todo.getBody());

//                        String line = null;
//                        StringBuffer sb = new StringBuffer();
//                        while ( (line = reader.readLine()) != null  ) {
//                            sb.append(line +"\n");
//                        }
//                        Log.d(TAG, sb.toString());
//                        String responseResult = sb.toString();
//                        String key = responseResult.substring(3, 10);
//                        String value = responseResult.substring(11, 14);
//                        Log.d(TAG, "key : " + key);
//                        Log.d(TAG, "value : " + value);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}

 