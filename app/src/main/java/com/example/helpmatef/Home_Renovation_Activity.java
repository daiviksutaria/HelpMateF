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

public class Home_Renovation_Activity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_renovation);

        sharedPreferences = getSharedPreferences("cart", Context.MODE_PRIVATE);

        Button basicCleaningBtn = findViewById(R.id.full_home);
        Button deepCleaningBtn = findViewById(R.id.kitchen_bath);
        Button moveCleaningBtn = findViewById(R.id.living_bed);

        basicCleaningBtn.setOnClickListener(view -> addToCart("Full Home Renorvation"));
        deepCleaningBtn.setOnClickListener(view -> addToCart("Kitchen Renorvation"));
        moveCleaningBtn.setOnClickListener(view -> addToCart("Living Room Renorvation"));
    }

    private void addToCart(String itemName) {
        int quantity = sharedPreferences.getInt(itemName, 0);
        sharedPreferences.edit().putInt(itemName, quantity + 1).apply();
        Toast.makeText(this, itemName + " added to cart", Toast.LENGTH_SHORT).show();
    }


    }
