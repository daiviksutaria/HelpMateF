package com.example.helpmatef;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Home_Cleaning_Activity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_cleaning2);

        // Step 1: Init SharedPreferences
        sharedPreferences = getSharedPreferences("cart", Context.MODE_PRIVATE);

        // Step 2: Buttons
        Button basicCleaningBtn = findViewById(R.id.basic_cleaning);
        Button deepCleaningBtn = findViewById(R.id.deep_cleaning);
        Button moveCleaningBtn = findViewById(R.id.move_cleaning);

        // Step 3: Set click listeners
        basicCleaningBtn.setOnClickListener(view -> addToCart("Basic House Cleaning"));
        deepCleaningBtn.setOnClickListener(view -> addToCart("Deep House Cleaning"));
        moveCleaningBtn.setOnClickListener(view -> addToCart("Move-In/Move-Out Cleaning"));
    }

    private void addToCart(String itemName) {
        int quantity = sharedPreferences.getInt(itemName, 0);
        sharedPreferences.edit().putInt(itemName, quantity + 1).apply();
        Toast.makeText(this, itemName + " added to cart", Toast.LENGTH_SHORT).show();
    }
}
