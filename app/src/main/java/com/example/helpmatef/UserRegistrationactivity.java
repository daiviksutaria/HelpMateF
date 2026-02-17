package com.example.helpmatef;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class UserRegistrationactivity extends AppCompatActivity {
    private EditText etName,etEmail, etPassword, etConfirmPassword;
    private Button btnSignUp;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registrationactivity);

        etEmail = findViewById(R.id.Email);
        etName = findViewById(R.id.FirstName);
        etPassword = findViewById(R.id.Password);
        etConfirmPassword = findViewById(R.id.ConfirmPassword);
        btnSignUp = findViewById(R.id.SignUp);
        dbHandler = new DBHandler(this);

        btnSignUp.setOnClickListener(v -> registerUser());
    }

    private void registerUser() {
        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String confirmPassword = etConfirmPassword.getText().toString().trim();

        Log.d("USER_REGISTRATION", "User entered: Name = " + name + ", Email = " + email);

        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!password.equals(confirmPassword)) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean isRegistered = dbHandler.registerUser(name, email, password);

        if (isRegistered) {
            Log.d("USER_REGISTRATION", "Registration successful for: " + email);
            Toast.makeText(this, "Signup Successful!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(UserRegistrationactivity.this, UserLoginActivity.class));
            finish();
        } else {
            Log.d("USER_REGISTRATION", "User already exists: " + email);
            Toast.makeText(this, "User already exists!", Toast.LENGTH_SHORT).show();
        }
    }

}


