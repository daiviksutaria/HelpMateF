package com.example.helpmatef;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class In_Home_Cleaning_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_in_home_cleaning);

        // Find the layout references
        LinearLayout homeCleaningLayout = findViewById(R.id.homecleaning);
        LinearLayout sofaCleaningLayout = findViewById(R.id.sofacleaning);

        // Set click listener for Home Cleaning
        homeCleaningLayout.setOnClickListener(v -> {
            Intent intent = new Intent(In_Home_Cleaning_Activity.this, Home_Cleaning_Activity.class);
            startActivity(intent);
        });

        // Set click listener for Sofa Cleaning
        sofaCleaningLayout.setOnClickListener(v -> {
            Intent intent = new Intent(In_Home_Cleaning_Activity.this, Sofa_Cleaning_Activity.class);
            startActivity(intent);
        });
    }
}
