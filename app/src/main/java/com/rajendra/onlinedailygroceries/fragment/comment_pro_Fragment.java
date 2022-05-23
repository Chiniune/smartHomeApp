package com.rajendra.onlinedailygroceries.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.rajendra.onlinedailygroceries.R;
import com.rajendra.onlinedailygroceries.adapter.CommentAdapter;
import com.rajendra.onlinedailygroceries.model.Comment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class comment_pro_Fragment extends Fragment {

    RecyclerView cmtRecycler;
    CommentAdapter commentAdapter;

    //floating button
    FloatingActionButton fabCmt;
    boolean fabCmtHide = false;
    LinearLayout fabCmtLayout;
    EditText contentCmtProduct;
    Button sendCmtProduct;

    public comment_pro_Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comment_pro, container, false);


//      get all comment
        cmtRecycler = view.findViewById(R.id.cmtRecycler);
        final List<Comment> cmtlist = new ArrayList<>();
        cmtlist.add(new Comment("Chin", R.drawable.b4, 4, "2021-11-12 15:12:22", "omg luon ne alibababba kajshc afg adjh ka lla uwe áu ajhd bcbj jad"));
        cmtlist.add(new Comment("Chin abcd", R.drawable.b4, 3, "2022-12-12 15:12:22", "oii oooi oiii"));
//        cmtlist.add(new Comment("Chin iu", R.drawable.b4, 2, "1110-06-12 15:12:22", "omg luon ne"));
        cmtlist.add(new Comment("sfjgs sj sb", R.drawable.b4, 1, "1231-06-12 15:12:22", "ggooood"));
        getAllCmt(cmtlist);

        //floating button cmt
        contentCmtProduct = view.findViewById(R.id.contentCmtProduct);
        sendCmtProduct = view.findViewById(R.id.sendCmtProduct);
        sendCmtProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Calendar cal = Calendar.getInstance();
                String date = dateFormat.format(cal.getTime());
                cmtlist.add(new Comment("Chin aaa", R.drawable.b4, 3, date, contentCmtProduct.getText().toString()));
                commentAdapter.notifyItemInserted(cmtlist.size()-1);
                //hide cmt
                fabCmtHide  =false;
                fabCmtLayout.setVisibility(View.GONE);
                //hide keyboard
                InputMethodManager imm = (InputMethodManager)getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        });
        fabCmtLayout = view.findViewById(R.id.fabCmtLayout);
        fabCmt  =view.findViewById(R.id.fabCommment);
        fabCmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fabCmtHide == false) {
                    fabCmtHide = true;
                    fabCmtLayout.setVisibility(View.VISIBLE);
                    //show keyboard
                    contentCmtProduct.requestFocus();
                    InputMethodManager imm = (InputMethodManager)getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.showSoftInput(contentCmtProduct, InputMethodManager.SHOW_IMPLICIT);
                    //margin

                } else {
                    //hide cmt
                    fabCmtHide  =false;
                    fabCmtLayout.setVisibility(View.GONE);
                    //hide keyboard
                    InputMethodManager imm = (InputMethodManager)getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
            }
        });
        return view;
    }

    private void  getAllCmt(List<Comment> cmtlist) {
        commentAdapter = new CommentAdapter(this.getContext(), cmtlist);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
        cmtRecycler.setLayoutManager(layoutManager);
        cmtRecycler.setAdapter(commentAdapter);
        commentAdapter.notifyDataSetChanged();
    }
}