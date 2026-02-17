package com.example.helpmatef;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class wo_salon_adapter extends RecyclerView.Adapter<wo_salon_adapter.ViewHolder> {
    private final List<Wo_salon_model> itemList;
    private final Context context;

    public wo_salon_adapter(List<Wo_salon_model> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wo_salon_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Wo_salon_model item = itemList.get(position);

        // Set data in Views
        holder.brandName.setText(item.getBrandName());  // Assuming there's a brand name field
        holder.productTitle.setText(item.getProductTitle());
        holder.productPrice.setText("₹" + item.getPrice());
        holder.productDuration.setText("• " + item.getDuration());
        holder.productRating.setText("⭐ " + item.getRating());

        // Set product image
        holder.productImage.setImageResource(item.getImageResId());

        // Set Add to Cart button functionality
        holder.addButton.setOnClickListener(v -> {
            CartManager.getInstance().addItem(item);
            Toast.makeText(context, item.getProductTitle() + " added to cart", Toast.LENGTH_SHORT).show();
        });

        // Styling
        holder.addButton.setBackgroundColor(Color.BLACK);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView brandName, productTitle, productPrice, productDuration, productRating;
        ImageView productImage;
        Button addButton;

        public ViewHolder(View itemView) {
            super(itemView);

            // Initialize Views from wo_salon_item.xml
            brandName = itemView.findViewById(R.id.brandName);
            productTitle = itemView.findViewById(R.id.productTitle);
            productPrice = itemView.findViewById(R.id.productPrice);
            productDuration = itemView.findViewById(R.id.productDuration);
            productRating = itemView.findViewById(R.id.productRating);
            productImage = itemView.findViewById(R.id.productImage);
            addButton = itemView.findViewById(R.id.addButton);
        }
    }
}
