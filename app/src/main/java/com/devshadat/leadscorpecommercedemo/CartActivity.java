package com.devshadat.leadscorpecommercedemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.devshadat.leadscorpecommercedemo.adapters.CartAdapter;
import com.devshadat.leadscorpecommercedemo.data.CartTable;
import com.devshadat.leadscorpecommercedemo.databinding.ActivityCartBinding;
import com.devshadat.leadscorpecommercedemo.viewmodels.CartViewModel;

import java.util.List;
import java.util.Objects;

public class CartActivity extends AppCompatActivity {

    private ActivityCartBinding binding;
    private CartViewModel cartViewModel;

    private CartAdapter adapter;
    List<CartTable> quesList;

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

        cartViewModel.getmAllQuestions().observe(this, new Observer<List<CartTable>>() {
            @Override
            public void onChanged(List<CartTable> quizTables) {

                quesList = quizTables;
                Log.e("erer", "onChanged: " + quizTables.get(0).getTitle());
                adapter = new CartAdapter();
                RecyclerView recyclerView = binding.cartRecyclerView;
                recyclerView.setLayoutManager(new LinearLayoutManager(CartActivity.this));
                recyclerView.setAdapter(adapter);
                adapter.setResults(quesList);

            }
        });


        binding.placeOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CartActivity.this, "Demo Complete", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void fetchData(List<CartTable> quizTables) {
        quesList = quizTables;
    }


}