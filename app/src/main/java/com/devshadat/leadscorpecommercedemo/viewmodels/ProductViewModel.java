package com.devshadat.leadscorpecommercedemo.viewmodels;

import android.location.Location;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.devshadat.leadscorpecommercedemo.data.Product;
import com.devshadat.leadscorpecommercedemo.repos.ProductRepository;

import java.util.List;

public class ProductViewModel extends ViewModel {

    private ProductRepository repository;

    public ProductViewModel() {
        repository = new ProductRepository();
    }

    public MutableLiveData<List<Product>> getAllProducts() {
        return repository.getResponse();

    }


}
