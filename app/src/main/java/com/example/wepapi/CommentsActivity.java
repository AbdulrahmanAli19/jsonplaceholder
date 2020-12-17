package com.example.wepapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CommentsActivity extends AppCompatActivity {
    private static final String TAG = "CommentsActivity";
    private WebAPI api;
    private static String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private CommentsAdapter adapter;
    private Retrofit retrofit;
    private Toolbar toolbar;
    private String postId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        postId = getIntent().getStringExtra("POST_ID");
        recyclerView = findViewById(R.id.recyclerview);
        toolbar = findViewById(R.id.toolbar);
        progressBar = findViewById(R.id.progressPar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("CommentsOFPost"+postId);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_round_arrow_back_24));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        getComments();
    }

    private void getComments() {
        api = retrofit.create(WebAPI.class);
        Call<List<Comment>> call = api.getCommentAt(postId);

        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if (!response.isSuccessful()) {
                    Log.d(TAG, "onResponse: " + response.code());
                    return;
                }

                List<Comment> posts = response.body();
                if (posts.size() != 0) {
                    progressBar.setVisibility(View.GONE);
                    adapter = new CommentsAdapter(CommentsActivity.this, posts);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                toolbar.setVisibility(View.GONE);
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}