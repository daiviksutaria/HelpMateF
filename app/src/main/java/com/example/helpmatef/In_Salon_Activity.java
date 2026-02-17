package com.example.helpmatef;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class In_Salon_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_salon);

        TextView textView = findViewById(R.id.textView);
        textView.setTextColor(getResources().getColor(R.color.black));


        // RecyclerView Setup
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); // Important for AppCompatActivity

        // Handle back button click
        toolbar.setNavigationOnClickListener(v -> {
            // You can customize what happens on back press (finish the activity)
            onBackPressed(); // This finishes the current activity and goes back
        });

        List<SalonModel> salonList = new ArrayList<>();
        salonList.add(new SalonModel("Woman'Salon & Spa", "Also for kids", "Ainhoa | Casmara | Cirépil", R.drawable.wo_hair_cut, "WOMEN"));
        salonList.add(new SalonModel("Men's Salon & Spa", "Also for kids", "Elysian | Rica | Inveda", R.drawable.men_hir_cut, "MEN"));


        recyclerView.setAdapter(new SalonAdapter(salonList, this));
    }
}
