package com.rajendra.onlinedailygroceries.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rajendra.onlinedailygroceries.R;
import com.rajendra.onlinedailygroceries.adapter.AllProductAdapter;
import com.rajendra.onlinedailygroceries.model.AllProducts;

import java.util.ArrayList;
import java.util.List;

public class related_pro_Fragment extends Fragment {

    RecyclerView allProRecycler;
    AllProductAdapter allProductAdapter;

    public related_pro_Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_related_pro, container, false);

        allProRecycler = view.findViewById(R.id.allProductRecycler);
        List<AllProducts> allList = new ArrayList<>();
        allList.add(new AllProducts(1, "abd efg air vvv alibaba vvv vvv hmm omg s", "New Arrival", 24, 54, R.drawable.b4));
        allList.add(new AllProducts(1, "ha hbn hiab sfss", "New jghk", 56, 78, R.drawable.b4));
        allList.add(new AllProducts(1, "camera abc", "Best Seller", 234, 34, R.drawable.b4));
        allList.add(new AllProducts(1, "abd efg air conditional alibaba omg luon hmm omg s", "New Arrival", 12, 1, R.drawable.b4));
        allList.add(new AllProducts(1, "ahh aahh", "New bebib", 33, 34, R.drawable.b4));
        allList.add(new AllProducts(1, "abd efg air nmsds alibaba omg luon hmm omg s", "New abcd", 11, 9, R.drawable.b4));
        getAllProduct(allList);
        return view;
    }

    private void getAllProduct(List<AllProducts> allList) {
        allProductAdapter = new AllProductAdapter(this.getContext(), allList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getContext(), 2, GridLayoutManager.VERTICAL, false);
        allProRecycler.setLayoutManager(gridLayoutManager);
        allProRecycler.setAdapter(allProductAdapter);
    }
}