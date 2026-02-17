package com.example.helpmatef;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Sofa_Cleaning_Activity extends AppCompatActivity {
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sofa_cleaning);
        sharedPreferences = getSharedPreferences("cart", Context.MODE_PRIVATE);

        Button basicCleaningBtn = findViewById(R.id.sofa_cleaning);
        Button deepCleaningBtn = findViewById(R.id.bed_cleaning);
        Button moveCleaningBtn = findViewById(R.id.upholstery_cleaning);

        basicCleaningBtn.setOnClickListener(view -> addToCart("Sofa Cleaning"));
        deepCleaningBtn.setOnClickListener(view -> addToCart("Badsheet Cleanong"));
        moveCleaningBtn.setOnClickListener(view -> addToCart("Upholstery Cleaning"));
    }

    private void addToCart(String itemName) {
        int quantity = sharedPreferences.getInt(itemName, 0);
        sharedPreferences.edit().putInt(itemName, quantity + 1).apply();
        Toast.makeText(this, itemName + " added to cart", Toast.LENGTH_SHORT).show();
    }
}