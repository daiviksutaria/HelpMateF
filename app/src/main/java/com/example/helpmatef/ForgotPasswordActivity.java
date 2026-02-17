package com.example.helpmatef;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ForgotPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_forgot_password); // 🛠️ Add your correct layout name here

        Button send = findViewById(R.id.sendmail);

        send.setOnClickListener(v -> {
            Intent sendIntent = new Intent(ForgotPasswordActivity.this, UserLoginActivity.class);
            startActivity(sendIntent); // ✅ You need to start the activity
        });
    }
}
