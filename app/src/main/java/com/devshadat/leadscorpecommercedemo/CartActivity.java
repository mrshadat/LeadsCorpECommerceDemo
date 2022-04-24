package com.devshadat.leadscorpecommercedemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.devshadat.leadscorpecommercedemo.adapters.CartAdapter;
import com.devshadat.leadscorpecommercedemo.data.Product;
import com.devshadat.leadscorpecommercedemo.databinding.ActivityCartBinding;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    private ActivityCartBinding binding;
    private CartViewModel cartViewModel;

    private CartAdapter adapter;
    private List<Product> cartList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cart);
        cartViewModel = ViewModelProviders.of(this).get(CartViewModel.class);
        binding.setLifecycleOwner(this);

        adapter = new CartAdapter();

        RecyclerView recyclerView = binding.cartRecyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}