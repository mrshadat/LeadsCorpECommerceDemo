package com.devshadat.leadscorpecommercedemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Toast;

import com.devshadat.leadscorpecommercedemo.adapters.ProductCategoryAdapter;
import com.devshadat.leadscorpecommercedemo.data.Category;
import com.devshadat.leadscorpecommercedemo.data.Product;
import com.devshadat.leadscorpecommercedemo.databinding.ActivityMainBinding;
import com.devshadat.leadscorpecommercedemo.viewmodels.ProductViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ProductViewModel productViewModel;
    private ActivityMainBinding binding;

    private ProductCategoryAdapter adapter;
    private List<Category> categoryList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        productViewModel = ViewModelProviders.of(this).get(ProductViewModel.class);
        // Objects.requireNonNull(getSupportActionBar()).setTitle("Category");
        setSupportActionBar(binding.toolbar);
        binding.toolbar.setLogo(getResources().getDrawable(R.drawable.ic_baseline_person_white_24));
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);

        binding.toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
        // adapter = new ProductCategoryAdapter();

        /*RecyclerView recyclerView = binding.categoryRecycler;
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter)*/
        ;


        productViewModel.getAllElectronicProducts().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                productViewModel.electronicsQuantity.setValue(String.valueOf(products.size()));
            }
        });

        productViewModel.getAllJeweleryProducts().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                productViewModel.jeweleryQuantity.setValue(String.valueOf(products.size()));
            }
        });

        productViewModel.getAllMenClothingProducts().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                productViewModel.menClothQuantity.setValue(String.valueOf(products.size()));
            }
        });

        productViewModel.getAllWomenClothingProducts().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                productViewModel.womenClothQuantity.setValue(String.valueOf(products.size()));
            }
        });


        productViewModel.menClothQuantity.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.textMenClothCount.setText("item: " + s);
            }
        });

        productViewModel.womenClothQuantity.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.textWomenClothCount.setText("item: " + s);
            }
        });

        productViewModel.jeweleryQuantity.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.textJeweleryCount.setText("item: " + s);
            }
        });

        productViewModel.electronicsQuantity.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.textElectronicsCount.setText("item: " + s);
            }
        });


        binding.cardElectronics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ProductListActivity.class);
                intent.putExtra("type", "electronics");
                startActivity(intent);
            }
        });

        binding.cardJewelery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ProductListActivity.class);
                intent.putExtra("type", "jewelery");
                startActivity(intent);
            }
        });

        binding.cardMensCloth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ProductListActivity.class);
                intent.putExtra("type", "menCloth");
                startActivity(intent);
            }
        });

        binding.cardWomenCloth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ProductListActivity.class);
                intent.putExtra("type", "womenCloth");
                startActivity(intent);
            }
        });

    }
}