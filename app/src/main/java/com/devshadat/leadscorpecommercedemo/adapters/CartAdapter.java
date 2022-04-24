package com.devshadat.leadscorpecommercedemo.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devshadat.leadscorpecommercedemo.R;
import com.devshadat.leadscorpecommercedemo.data.CartItem;
import com.devshadat.leadscorpecommercedemo.data.Product;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private List<Product> results = new ArrayList<>();

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cart_row, parent, false);

        return new CartViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {

        Product volume = results.get(position);
        String price = "BDT " + String.valueOf(volume.getPrice());
        holder.productTitle.setText(volume.getTitle());


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


    static class CartViewHolder extends RecyclerView.ViewHolder {
        private TextView productTitle;
        private ImageView productImage;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);

            productTitle = itemView.findViewById(R.id.productNameTextView);
            productImage = itemView.findViewById(R.id.productImageView);

        }
    }
}
