package com.example.helpmatef;

public class AccountOption {
    private int iconRes;
    private String text;

    public AccountOption(int iconRes, String text) {
        this.iconRes = iconRes;
        this.text = text;
    }

    public int getIconRes() {
        return iconRes;
    }

    public String getText() {
        return text;
    }
}

