package com.example.helpmatef;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.Locale;

public class ChoosePathActivity extends AppCompatActivity {

    private Button userButton, workerButton, changeLangButton;
    private int originalUserColor, originalWorkerColor;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_path);

        userButton = findViewById(R.id.HelpButton);
        workerButton = findViewById(R.id.SkillsButton);
        changeLangButton = findViewById(R.id.changeLangButton); // Button for changing language


        // Store original colors
        originalUserColor = userButton.getBackgroundTintList() != null ?
                userButton.getBackgroundTintList().getDefaultColor() : Color.LTGRAY;
        originalWorkerColor = workerButton.getBackgroundTintList() != null ?
                workerButton.getBackgroundTintList().getDefaultColor() : Color.LTGRAY;

        // User Button Touch Listener
        userButton.setOnTouchListener((v, event) -> {

           if (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) {
                userButton.setBackgroundColor(originalUserColor);
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    startActivity(new Intent(ChoosePathActivity.this, UserLoginActivity.class));
                }
            }
            return false;
        });

        // Worker Button Touch Listener
        workerButton.setOnTouchListener((v, event) -> {
            if(event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) {
                workerButton.setBackgroundColor(originalWorkerColor);
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    startActivity(new Intent(ChoosePathActivity.this, WorkerActivity.class));
                }
            }
            return false;
        });

        // Change Language Popup Menu
        changeLangButton.setOnClickListener(v -> showLanguageMenu(v));
    }

    private void showLanguageMenu(View anchor) {
        PopupMenu popup = new PopupMenu(this, anchor);
        popup.getMenu().add("English");
        popup.getMenu().add("Hindi");
        popup.getMenu().add("Gujrati");
        //popup.getMenu().add("spanish");

        popup.setOnMenuItemClickListener(item -> {
            String selectedLang = item.getTitle().toString();
            if (selectedLang.equals("English")) {
                setLocale("en");
            } else if (selectedLang.equals("Hindi")) {
                setLocale("hi");
            }else if (selectedLang.equals("Gujrati")) {
                setLocale("gu");
            }else if (selectedLang.equals("Spanish")) {
                setLocale("es");
            }
            return true;
        });

        popup.show();
    }

    private void setLocale(String langCode) {
        Locale locale = new Locale(langCode);
        Locale.setDefault(locale);
        Resources resources = getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);
        resources.updateConfiguration(config, resources.getDisplayMetrics());

        recreate(); // Refresh activity
    }
}
