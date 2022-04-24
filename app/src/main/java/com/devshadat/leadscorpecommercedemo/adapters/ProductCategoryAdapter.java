package com.devshadat.leadscorpecommercedemo.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devshadat.leadscorpecommercedemo.R;
import com.devshadat.leadscorpecommercedemo.data.Product;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ProductCategoryAdapter extends RecyclerView.Adapter<ProductCategoryAdapter.ProductCategoryViewHolder> {
    private List<Product> results = new ArrayList<>();

    @Override
    public ProductCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_list_item, parent, false);

        return new ProductCategoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductCategoryViewHolder holder, int position) {
        Product volume = results.get(position);

        String price = "BDT " + String.valueOf(volume.getPrice());

        holder.productTitle.setText(volume.getTitle());
        holder.productTitle.setText(volume.getTitle());
        holder.productPrice.setText(price);


        if (volume.getImage() != null) {
            String imageUrl = volume.getImage();

            Picasso.get().load(imageUrl).into(holder.productImage);
        }
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
        private TextView productTitle;
        private TextView productPrice;
        private ImageView productImage;

        public ProductCategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            productTitle = itemView.findViewById(R.id.product_item_title);
            productPrice = itemView.findViewById(R.id.product_item_price);
            productImage = itemView.findViewById(R.id.product_item_img);

        }
    }
}