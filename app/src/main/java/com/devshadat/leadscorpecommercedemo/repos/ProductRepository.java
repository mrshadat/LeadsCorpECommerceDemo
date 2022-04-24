package com.devshadat.leadscorpecommercedemo.repos;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.devshadat.leadscorpecommercedemo.data.Product;
import com.devshadat.leadscorpecommercedemo.request.ProductRequestAPI;
import com.devshadat.leadscorpecommercedemo.util.RetrofitClient;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductRepository {

    private static final String TAG = ProductRepository.class.getSimpleName();

    private MutableLiveData<List<Product>> nearbyLD = new MutableLiveData<>();

    public MutableLiveData<List<Product>> getResponse() {

        ProductRequestAPI serviceApi =
                RetrofitClient.getClientForProduct()
                        .create(ProductRequestAPI.class);


        serviceApi.getAllProducts().enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(@NonNull Call<List<Product>> call, @NonNull Response<List<Product>> response) {
                if (response.isSuccessful()) {

                    nearbyLD.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });



        return nearbyLD;
    }

}
