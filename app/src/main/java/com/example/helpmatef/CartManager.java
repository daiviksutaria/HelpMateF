package com.example.helpmatef;

import java.util.ArrayList;
import java.util.List;

public class CartManager {
    private static CartManager instance;
    private final List<Wo_salon_model> cartItems;

    private CartManager() {
        cartItems = new ArrayList<>();
    }

    public static synchronized CartManager getInstance() {
        if (instance == null) {
            instance = new CartManager();
        }
        return instance;
    }

    public void addItem(Wo_salon_model item) {
        cartItems.add(item);
    }

    public List<Wo_salon_model> getCartItems() {
        return cartItems;
    }
}
