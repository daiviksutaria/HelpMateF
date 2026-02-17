package com.example.helpmatef;

public class SalonModel {
    private String title, description, brands, type;
    private int imageResId;

    // Constructor
    public SalonModel(String title, String description, String brands, int imageResId, String type) {
        this.title = title;
        this.description = description;
        this.brands = brands;
        this.imageResId = imageResId;
        this.type = (type != null) ? type : "UNKNOWN"; // Ensure type is never null
    }


    // Getters
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getBrands() { return brands; }
    public int getImageResId() { return imageResId; }
    public String getType() { return type; }
}
