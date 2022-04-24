package com.devshadat.leadscorpecommercedemo.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.devshadat.leadscorpecommercedemo.data.Category;
import com.devshadat.leadscorpecommercedemo.repos.CategoryRepository;

import java.util.List;

public class CategoryViewModel extends ViewModel {

    private CategoryRepository repository;

    public CategoryViewModel() {
        repository = new CategoryRepository();
    }

    public MutableLiveData<List<Category>> getAllCategories() {
        return repository.getResponse();

    }


}