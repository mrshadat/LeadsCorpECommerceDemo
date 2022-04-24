package com.devshadat.leadscorpecommercedemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.devshadat.leadscorpecommercedemo.adapters.ProductCategoryAdapter;
import com.devshadat.leadscorpecommercedemo.data.Category;
import com.devshadat.leadscorpecommercedemo.data.Product;
import com.devshadat.leadscorpecommercedemo.databinding.ActivityMainBinding;
import com.devshadat.leadscorpecommercedemo.viewmodels.CategoryViewModel;
import com.devshadat.leadscorpecommercedemo.viewmodels.ProductViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ProductViewModel productViewModel;
    private CategoryViewModel categoryViewModel;
    private ActivityMainBinding binding;
    private ProductCategoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        productViewModel = ViewModelProviders.of(this).get(ProductViewModel.class);
        adapter = new ProductCategoryAdapter();

        RecyclerView recyclerView = binding.categoryRecycler;
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);


        productViewModel.getAllProducts().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                adapter.setResults(products);
            }
        });

    }
}