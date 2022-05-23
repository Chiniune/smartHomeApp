package com.rajendra.onlinedailygroceries.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rajendra.onlinedailygroceries.BlogDetailsActivity;
import com.rajendra.onlinedailygroceries.Constants;
import com.rajendra.onlinedailygroceries.R;
import com.rajendra.onlinedailygroceries.model.Blog;

import java.io.Serializable;
import java.util.List;

public class blogPageAdapter extends RecyclerView.Adapter<blogPageAdapter.blogPageViewHolder> {

    Context context;
    List<Blog> listBlog;

    public blogPageAdapter(Context context, List<Blog> listBlog) {
        this.context = context;
        this.listBlog = listBlog;
    }

    @NonNull
    @Override
    public blogPageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.blog_item, parent, false);

        return new blogPageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull blogPageViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.tag.setText(listBlog.get(position).getTag());
        holder.author.setText(listBlog.get(position).getAuthor());
        holder.date.setText(listBlog.get(position).getDate());
        holder.title.setText(listBlog.get(position).getTitle());
        holder.content.setText(listBlog.get(position).getContent());
//        holder.img.setImageResource(listBlog.get(position).getImageUrl());
        Glide.with(context).load("http://"+ Constants.Host +":8080/User/assets/images/blog/"+
                listBlog.get(position).getImage()).into(holder.img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, BlogDetailsActivity.class);
                i.putExtra("blogDetail", (Serializable) listBlog.get(position));
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listBlog.size();
    }

    public static class blogPageViewHolder extends RecyclerView.ViewHolder{

        TextView tag, author, date, title, content;
        ImageView img;

        public blogPageViewHolder(@NonNull View itemView) {
            super(itemView);

            tag = itemView.findViewById(R.id.txtTagContentBlog);
            author = itemView.findViewById(R.id.txtAuthorContentBlog);
            date = itemView.findViewById(R.id.txtDateContentBlog);
            title = itemView.findViewById(R.id.txtTitleBlog);
            content = itemView.findViewById(R.id.txtContentBlog);
            img = itemView.findViewById(R.id.blogImage);
        }
    }

}
