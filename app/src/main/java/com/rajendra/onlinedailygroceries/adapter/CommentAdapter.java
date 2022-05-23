package com.rajendra.onlinedailygroceries.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rajendra.onlinedailygroceries.R;
import com.rajendra.onlinedailygroceries.model.Comment;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {

    Context context;
    List<Comment> listComment;

    public CommentAdapter(Context context, List<Comment> listComment) {
        this.context = context;
        this.listComment = listComment;
    }

    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_comment_pro_item, parent, false);

        return new CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.rating.setRating(listComment.get(position).getRating());
        holder.username.setText(listComment.get(position).getUsername());
        holder.date.setText(listComment.get(position).getDate());
        holder.content.setText(listComment.get(position).getContent());
        holder.avt.setBackgroundResource(listComment.get(position).getImageUrl());

    }

    @Override
    public int getItemCount() {
        return listComment.size();
    }

    public static class CommentViewHolder extends RecyclerView.ViewHolder{

        TextView username, content, date;
        ImageView avt;
        RatingBar rating;

        public CommentViewHolder(@NonNull View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.username);
            rating = itemView.findViewById(R.id.ratingBar_cmt);
            date = itemView.findViewById(R.id.date_cmt);
            content = itemView.findViewById(R.id.content_cmt);
            avt = itemView.findViewById(R.id.avt_cmt);
        }
    }

}
