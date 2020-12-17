package com.example.wepapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WebAPI {

    @GET("posts")
    Call<List<Post>> getAllPosts();

    @GET("comments")
    Call<List<Comment>> getAllComments();

    @GET("posts/{post_id}/comments")
    Call<List<Comment>> getCommentAt(@Path(value = "post_id") String userId);
}
