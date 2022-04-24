package com.devshadat.leadscorpecommercedemo.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devshadat.leadscorpecommercedemo.R;
import com.devshadat.leadscorpecommercedemo.data.Category;
import com.devshadat.leadscorpecommercedemo.data.Product;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import okhttp3.internal.Util;

public class ProductCategoryAdapter extends RecyclerView.Adapter<ProductCategoryAdapter.ProductCategoryViewHolder> {
    private List<Product> results = new ArrayList<>();
    private List<Category> categories = new ArrayList<>();

    @NonNull
    @Override
    public ProductCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_item, parent, false);

        return new ProductCategoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductCategoryViewHolder holder, int position) {
        Product volume = results.get(position);

        holder.titleTextView.setText(volume.getCategory());

      /*  if (volume.getImage() != null) {
            String imageUrl = volume.getImage();

            Picasso.get().load(imageUrl).into(holder.smallThumbnailImageView);
        }*/
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public void setResults(List<Product> products) {
        this.results = products;

        notifyDataSetChanged();
    }

    class ProductCategoryViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView;
        private TextView productCountTextView;
        private TextView authorsTextView;
        private TextView publishedDateTextView;
        private ImageView smallThumbnailImageView;

        public ProductCategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.text_product_category);

        }
    }
}