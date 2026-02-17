package com.example.helpmatef;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class UserLoginActivity extends AppCompatActivity {
    private EditText Email, Password;
    private Button loginbtn;
    private DBHandler dbHandler;
    protected TextView newsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);

        Email = findViewById(R.id.email);
        Password = findViewById(R.id.Password);
        loginbtn = findViewById(R.id.loginbtn);
        newsignup = findViewById(R.id.newsignup);
        dbHandler = new DBHandler(this);

        // Toolbar and Back Button
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(v -> {
            Intent intent = new Intent(this, ChoosePathActivity.class);
            startActivity(intent);
            finish();
        });

        // Skip Button
        TextView skipButton = findViewById(R.id.skipB);
        skipButton.setOnClickListener(v -> {
            Intent skipIntent = new Intent(UserLoginActivity.this, UserHomeActivity.class);
            startActivity(skipIntent);
            finish();
        });

        // Forgot Password
        TextView forgetPassword = findViewById(R.id.forgetpss);
        forgetPassword.setOnClickListener(v -> {
            Intent forgetIntent = new Intent(this, ForgotPasswordActivity.class);
            startActivity(forgetIntent);
        });

        // Login Button
        loginbtn.setOnClickListener(v -> {
            String email = Email.getText().toString().trim();
            String password = Password.getText().toString().trim();

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(UserLoginActivity.this, "Invalid email format", Toast.LENGTH_SHORT).show();
                return;
            }
            if (password.length() < 6) {
                Toast.makeText(UserLoginActivity.this, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show();
                return;
            }

            if (dbHandler.authenticateUser(email, password)) {
                // Save user email in SharedPreferences
                SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("user_email", email);
                editor.apply();
                Log.d("LOGIN_ACTIVITY", "User email saved in SharedPreferences: " + email);
                Toast.makeText(UserLoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(UserLoginActivity.this, UserHomeActivity.class));
                finish();
            } else {
                Toast.makeText(UserLoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
            }
        });

        // New Signup
        newsignup.setOnClickListener(v -> startActivity(new Intent(UserLoginActivity.this, UserRegistrationactivity.class)));
    }
}