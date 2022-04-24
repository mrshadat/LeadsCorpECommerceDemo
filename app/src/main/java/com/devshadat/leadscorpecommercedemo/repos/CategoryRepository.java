package com.devshadat.leadscorpecommercedemo.repos;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.devshadat.leadscorpecommercedemo.data.Category;
import com.devshadat.leadscorpecommercedemo.data.Product;
import com.devshadat.leadscorpecommercedemo.request.CategoryRequestAPI;
import com.devshadat.leadscorpecommercedemo.request.ProductRequestAPI;
import com.devshadat.leadscorpecommercedemo.util.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryRepository {

    private static final String TAG = CategoryRepository.class.getSimpleName();

    private MutableLiveData<List<Category>> nearbyLD = new MutableLiveData<>();

    public MutableLiveData<List<Category>> getResponse() {

        CategoryRequestAPI serviceApi =
                RetrofitClient.getClientForProduct()
                        .create(CategoryRequestAPI.class);


        serviceApi.getAllCategories().enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                if (response.isSuccessful()) {

                    nearbyLD.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {

            }
        });


        return nearbyLD;
    }
}
