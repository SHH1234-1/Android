package com.example.myretrofit2_v2.repository;

import com.example.myretrofit2_v2.models.request.ReqPost;
import com.example.myretrofit2_v2.models.response.ResPost;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * REST API
 * GET, POST, PUT , DELETE
 */
public interface PostService {

    @GET("posts/{id}")
    Call<ResPost> getPost(@Path("id") int id);

    @GET("posts")
    Call<List<ResPost>> getPostList();

    // @FieldMap HashMap<String, Object>
    // @Field("title") String title
    // @Body ReqPost
//    @POST("posts")
//    Call<ResPost> createPostMap(@FieldMap HashMap<String, Object> reqData);
//
//    @FormUrlEncoded
//    @POST("posts")
//    Call<ResPost> createPostField(@Field("title") String title,
//                                  @Field("body") String body, @Field("userId") int userId);

    @POST("posts")
    Call<ResPost> createPost(@Body ReqPost reqPost);

    @PUT("posts/{id}")
    Call<ResPost> putPost(@Path("id") int id, @Body ReqPost reqPost);


    @DELETE("posts/{id}")
    Call<Void> deletePost(@Path("id") int id);


    @FormUrlEncoded
    @GET("posts")
    Call<List<ResPost>> searchByUserId(@Field("userId") int userId);

}