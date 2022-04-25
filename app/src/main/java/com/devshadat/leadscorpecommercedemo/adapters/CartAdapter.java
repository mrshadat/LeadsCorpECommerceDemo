package com.devshadat.leadscorpecommercedemo.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devshadat.leadscorpecommercedemo.CartActivity;
import com.devshadat.leadscorpecommercedemo.R;
import com.devshadat.leadscorpecommercedemo.data.CartItem;
import com.devshadat.leadscorpecommercedemo.data.CartTable;
import com.devshadat.leadscorpecommercedemo.data.Product;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private List<CartTable> results = new ArrayList<>();

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cart_row, parent, false);

        return new CartViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {

        CartTable volume = results.get(position);
        String price = "BDT " + volume.getPrice();
        holder.productTitle.setText(volume.getTitle());
        holder.productPrice.setText(price);

        if (volume.getTitle() != null) {
            String imageUrl = volume.getImage();

            Picasso.get().load(imageUrl).into(holder.productImage);
        }

    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public void setResults(List<CartTable> products) {
        this.results = products;
        notifyDataSetChanged();
    }


    static class CartViewHolder extends RecyclerView.ViewHolder {
        private TextView productTitle;
        private TextView productPrice;
        private ImageView productImage;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);

            productTitle = itemView.findViewById(R.id.cart_product_title);
            productPrice = itemView.findViewById(R.id.cart_product_price);
            productImage = itemView.findViewById(R.id.productImageView);

        }
    }
}
