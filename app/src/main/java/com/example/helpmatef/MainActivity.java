package com.example.helpmatef;  // Change this to your package name

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Delay for 3 seconds, then move to HomeActivity
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            Intent intent = new Intent(MainActivity.this, ChoosePathActivity.class);
            startActivity(intent);
            finish();  // Close splash screen so user can't go back to it
        }, 3000); // 3000ms = 3 seconds
    }
}
