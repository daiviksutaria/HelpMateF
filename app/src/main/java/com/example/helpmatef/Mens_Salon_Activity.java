package com.example.helpmatef;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class Mens_Salon_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mens_salon); // Ensure this layout exists

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



        List<Wo_salon_model> salonList = new ArrayList<>();
        salonList.add(new Wo_salon_model("Hair Cut", "Best hair cut", 4.85,"300","1 hr 30 mins", R.drawable.men_hir_cut));
        salonList.add(new Wo_salon_model("Facial", "Deep Clean Facial", 4.5, "1155", "1 hr",R.drawable.men_salon_facial));
        salonList.add(new Wo_salon_model("Massage", "Full Body Massage", 4.8, "2000", "1 hr", R.drawable.men_salon_massage));
        salonList.add(new Wo_salon_model("Hair Coloring", "Vibrant Hair Color", 4.75, "1200", "2 hrs", R.drawable.men_salon_haircolor));
        salonList.add(new Wo_salon_model("Groom Package", "perfsct combo for Groom.", 4.9, "14000", "2 hr", R.drawable.men_salon_groom));

        recyclerView.setAdapter(new wo_salon_adapter(salonList, this));
    }
}
