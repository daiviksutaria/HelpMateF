package com.example.helpmatef;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class in_Architech_Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_architect);

        findViewById(R.id.layout_interior).setOnClickListener(v -> {
            Intent intent = new Intent(in_Architech_Activity.this, Interior_Design_Activity.class);
            startActivity(intent);
        });

        findViewById(R.id.layout_renovation).setOnClickListener(v -> {
            Intent intent = new Intent(in_Architech_Activity.this, Home_Renovation_Activity.class);
            startActivity(intent);
        });
    }
}
