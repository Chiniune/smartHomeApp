package com.rajendra.onlinedailygroceries;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.rajendra.onlinedailygroceries.model.Blog;
import com.rajendra.onlinedailygroceries.model.BlogDetail;
import com.rajendra.onlinedailygroceries.network.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BlogDetailsActivity extends AppCompatActivity {

    ImageView back;
    ImageView img1, img2, img3;
    TextView tag, author, date, title, ct1, ct2, ct3;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blog_detail);
        // get blog
        final Blog blog = (Blog) getIntent().getSerializableExtra("blogDetail");

        tag = findViewById(R.id.txtTagContentBlogDe);
        author = findViewById(R.id.txtAuthorContentBlogDe);
        date = findViewById(R.id.txtDateContentBlogDe);
        title = findViewById(R.id.txtTitleBlogDe);
        ct1 = findViewById(R.id.txtContentBlogDe1);
        ct2 = findViewById(R.id.txtContentBlogDe2);
        ct3 = findViewById(R.id.txtContentBlogDe3);
        img1 = findViewById(R.id.blogImage1);
        img2 = findViewById(R.id.blogImage2);
        img3 = findViewById(R.id.blogImage3);

////    dump data blog detail
        Call<BlogDetail> detail = ApiClient.getNewsService().getBlogDetail(blog.getIdblog());
        detail.enqueue(new Callback<BlogDetail>() {
            @Override
            public void onResponse(Call<BlogDetail> call, Response<BlogDetail> response) {
//                Toast.makeText(BlogDetailsActivity.this, response.body().toString(), Toast.LENGTH_SHORT).show();

                Glide.with(BlogDetailsActivity.this).load("http://"+ Constants.Host +":8080/User/assets/images/blog/"+
                        response.body().getImage()).into(img1);
                tag.setText(response.body().getTag());
                author.setText(response.body().getAuthor());
                date.setText(response.body().getDate());
                title.setText(response.body().getTitle());
                ct1.setText(response.body().getCt1());
                Glide.with(BlogDetailsActivity.this).load("http://"+ Constants.Host +":8080/User/assets/images/blog/"+
                        response.body().getImage1()).into(img2);
                ct2.setText(response.body().getCt2());
                ct3.setText(response.body().getCt3());
                Glide.with(BlogDetailsActivity.this).load("http://"+ Constants.Host +":8080/User/assets/images/blog/"+
                        response.body().getImage2()).into(img3);
            }

            @Override
            public void onFailure(Call<BlogDetail> call, Throwable t) {

            }
        });


        back = findViewById(R.id.backBlogDe);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BlogDetailsActivity.this, BlogPageActivity.class);
                startActivity(i);
            }
        });
    }
}
