package com.example.helpmatef;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helpmatef.Mens_Salon_Activity;
import com.example.helpmatef.R;
import com.example.helpmatef.SalonModel;
import com.example.helpmatef.activity_womens_salon;

import java.util.List;

public class SalonAdapter extends RecyclerView.Adapter<SalonAdapter.SalonViewHolder> {
    private List<SalonModel> salonList;
    private Context context;

    public SalonAdapter(List<SalonModel> salonList, Context context) {
        this.salonList = salonList;
        this.context = context;
    }

    @NonNull
    @Override
    public SalonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_salon, parent, false);
        return new SalonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SalonViewHolder holder, int position) {
        SalonModel salon = salonList.get(position);
        holder.title.setText(salon.getTitle());
        holder.brands.setText(salon.getBrands());
        holder.imageView.setImageResource(salon.getImageResId());

        // Handle Click on the Entire Item
        holder.itemView.setOnClickListener(v -> {
            Intent intent;
            if (salon.getType().equalsIgnoreCase("WOMEN")) {
                intent = new Intent(context, activity_womens_salon.class);
            } else {
                intent = new Intent(context, Mens_Salon_Activity.class);
            }
            intent.putExtra("salon_name", salon.getTitle());
            intent.putExtra("salon_brands", salon.getBrands());
            intent.putExtra("salon_image", salon.getImageResId());
            context.startActivity(intent);
        });
    }


    @Override
    public int getItemCount() {
        return salonList.size();
    }

    static class SalonViewHolder extends RecyclerView.ViewHolder {
        TextView title, brands;
        ImageView imageView;

        public SalonViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            brands = itemView.findViewById(R.id.brands);
            imageView = itemView.findViewById(R.id.profileImage);
        }
    }
}
