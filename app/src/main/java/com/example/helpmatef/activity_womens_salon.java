package com.example.helpmatef;

import android.os.Bundle;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;

import java.util.ArrayList;
import java.util.List;

public class activity_womens_salon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_womens_salon); // Ensure this layout exists

        // RecyclerView Setup
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Fix Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); // Important for AppCompatActivity

        // Handle back button click
        toolbar.setNavigationOnClickListener(v -> {
            // You can customize what happens on back press (finish the activity)
            onBackPressed(); // This finishes the current activity and goes back
        });

        // Create sample data
        List<Wo_salon_model> salonList = new ArrayList<>();
        salonList.add(new Wo_salon_model("Hair Cut", "Best hair cut", 4.85, "300", "1 hr 30 mins", R.drawable.wo_hair_cut));
        salonList.add(new Wo_salon_model("Facial", "Deep Clean Facial", 4.5, "1155", "1 hr", R.drawable.women_facial));
        salonList.add(new Wo_salon_model("Makeup", "Herbal Skin Glow", 4.9, "1500", "2 hr", R.drawable.women_makeup));
        salonList.add(new Wo_salon_model("Hair Styling", "Professional Hair Styling", 4.7, "700", "1 hr", R.drawable.wo_hair_style));
        salonList.add(new Wo_salon_model("Bridal Makeup", "Exclusive Bridal Makeup", 4.8, "3500", "3 hrs", R.drawable.wo_bridal));
        salonList.add(new Wo_salon_model("Massage", "Full Body Massage", 4.8, "2000", "1 hr", R.drawable.wo_massage));
        salonList.add(new Wo_salon_model("Hair Coloring", "Vibrant Hair Color", 4.75, "1200", "2 hrs", R.drawable.wo_hair_colcor));

        // Set adapter with context
        recyclerView.setAdapter(new wo_salon_adapter(salonList, this));
    }
}
