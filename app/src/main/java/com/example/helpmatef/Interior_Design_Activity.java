package com.example.helpmatef;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Interior_Design_Activity extends AppCompatActivity {
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_interior_design);

        sharedPreferences = getSharedPreferences("cart", Context.MODE_PRIVATE);

        Button basicCleaningBtn = findViewById(R.id.moduler);
        Button deepCleaningBtn = findViewById(R.id.fullhome);
        Button moveCleaningBtn = findViewById(R.id.luxary);

        basicCleaningBtn.setOnClickListener(view -> addToCart("modulerDesign"));
        deepCleaningBtn.setOnClickListener(view -> addToCart("Full Home Design"));
        moveCleaningBtn.setOnClickListener(view -> addToCart("muxary Design"));
    }

    private void addToCart(String itemName) {
        int quantity = sharedPreferences.getInt(itemName, 0);
        sharedPreferences.edit().putInt(itemName, quantity + 1).apply();
        Toast.makeText(this, itemName + " added to cart", Toast.LENGTH_SHORT).show();
    }

}
