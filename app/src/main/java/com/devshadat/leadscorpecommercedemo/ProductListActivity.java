package com.devshadat.leadscorpecommercedemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.devshadat.leadscorpecommercedemo.adapters.ProductCategoryAdapter;
import com.devshadat.leadscorpecommercedemo.data.Product;
import com.devshadat.leadscorpecommercedemo.databinding.ActivityProductListBinding;
import com.devshadat.leadscorpecommercedemo.viewmodels.ProductViewModel;

import java.util.List;

public class ProductListActivity extends AppCompatActivity {

    private ActivityProductListBinding binding;
    private ProductViewModel productViewModel;
    private ProductCategoryAdapter adapter;
    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_list);
        productViewModel = ViewModelProviders.of(this).get(ProductViewModel.class);
        adapter = new ProductCategoryAdapter();

        type = getIntent().getStringExtra("type");

        if (type.contains("electronics")) {
            productViewModel.getAllElectronicProducts().observe(this, new Observer<List<Product>>() {
                @Override
                public void onChanged(List<Product> products) {
                    adapter.setResults(products);
                }
            });
        } else if (type.contains("jewelery")) {
            productViewModel.getAllJeweleryProducts().observe(this, new Observer<List<Product>>() {
                @Override
                public void onChanged(List<Product> products) {
                    adapter.setResults(products);
                }
            });
        } else if (type.contains("menCloth")) {
            productViewModel.getAllMenClothingProducts().observe(this, new Observer<List<Product>>() {
                @Override
                public void onChanged(List<Product> products) {
                    adapter.setResults(products);
                }
            });
        } else if (type.contains("womenCloth")) {
            productViewModel.getAllWomenClothingProducts().observe(this, new Observer<List<Product>>() {
                @Override
                public void onChanged(List<Product> products) {
                    adapter.setResults(products);
                }
            });
        }


        RecyclerView recyclerView = binding.productRecycler;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


    }
}