package com.rajendra.onlinedailygroceries;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.rajendra.onlinedailygroceries.adapter.blogPageAdapter;
import com.rajendra.onlinedailygroceries.model.Blog;
import com.rajendra.onlinedailygroceries.network.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BlogPageActivity extends AppCompatActivity {

    FloatingActionButton btnBackHome;
    RecyclerView recyclerBlogItem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blog_activity);

        btnBackHome = findViewById(R.id.btnBackHome);
        btnBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BlogPageActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        recyclerBlogItem = findViewById(R.id.recyclerBlogItem);

        final List<Blog> blogList = new ArrayList<>();
        Call<List<Blog>> list = ApiClient.getNewsService().getAllBlog();
        list.enqueue(new Callback<List<Blog>>() {
            @Override
            public void onResponse(Call<List<Blog>> call, Response<List<Blog>> response) {
                if (response.isSuccessful()) {
//                    Toast.makeText(MainActivity.this, response.body().toString(), Toast.LENGTH_LONG).show();
                    blogList.addAll(response.body());
                    setBloglist(blogList);
                }
            }

            @Override
            public void onFailure(Call<List<Blog>> call, Throwable t) {
                Toast.makeText(BlogPageActivity.this, "fail", Toast.LENGTH_LONG).show();

            }
        });
//        List<BlogPage> blogList = new ArrayList<>();
//        blogList.add(new BlogPage("camera", "Chin", "2022-12-11 10:10:10", "Reel In The Best Wireless Headphones for 2021", "Recent events with COVID-19 are sure to see us all spending more time inside our connect", R.drawable.b1));
//        blogList.add(new BlogPage("camera", "Chin", "2022-12-11 10:10:10", "Reel In The Best Wireless Headphones for 2021", "Recent events with COVID-19 are sure to see us all spending more time inside our connect", R.drawable.b2));
//        blogList.add(new BlogPage("camera", "Chin", "2022-12-11 10:10:10", "Reel In The Best Wireless Headphones for 2021", "Recent events with COVID-19 are sure to see us all spending more time inside our connect", R.drawable.b3));
//        blogList.add(new BlogPage("camera", "Chin", "2022-12-11 10:10:10", "Reel In The Best Wireless Headphones for 2021", "Recent events with COVID-19 are sure to see us all spending more time inside our connect", R.drawable.b4));
//        blogList.add(new BlogPage("camera", "Chin", "2022-12-11 10:10:10", "Reel In The Best Wireless Headphones for 2021", "Recent events with COVID-19 are sure to see us all spending more time inside our connect", R.drawable.b1));
//        getBloglist(blogList);
    }

    public void setBloglist(List<Blog> blogList) {
        blogPageAdapter blogPageAdapter = new blogPageAdapter(this, blogList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerBlogItem.setLayoutManager(layoutManager);
        recyclerBlogItem.setAdapter(blogPageAdapter);
    }
}
