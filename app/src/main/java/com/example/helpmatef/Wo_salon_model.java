package com.example.helpmatef;

public class Wo_salon_model {
    private String brandName, productTitle, duration, price;
    private double rating;
    private int  imageResId;

    public Wo_salon_model(String brandName, String productTitle, double rating, String price, String duration, int imageResId) {
        this.brandName = brandName;
        this.productTitle = productTitle;
        this.rating = rating;
        this.price = price;
        this.duration = duration;
        this.imageResId = imageResId;
    }

    public String getBrandName() { return brandName; }
    public String getProductTitle() { return productTitle; }
    public double getRating() { return rating; }
    public String getPrice() { return price; }

    public String getDuration() { return duration; }
    public int getImageResId() { return imageResId; }
}

