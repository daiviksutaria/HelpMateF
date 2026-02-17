package com.example.helpmatef;

import android.os.Bundle;
import android.util.Log; // Import Log
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartFragment extends Fragment {

    private RecyclerView cartRecyclerView;
    private Button checkoutButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        cartRecyclerView = view.findViewById(R.id.cartRecyclerView);
        cartRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        checkoutButton = view.findViewById(R.id.cheakout);
        checkoutButton.setOnClickListener(v -> {
            Log.d("CartFragment", "Checkout button clicked");

            NavController navController = Navigation.findNavController(v);
            if (navController != null) {
                Log.d("CartFragment", "Navigating to bookingFragment");
                navController.navigate(R.id.bookingFragment);
            } else {
                Log.e("CartFragment", "NavController is null!");
            }
        });

        updateCart();
        return view;
    }

    private void updateCart() {
        List<Wo_salon_model> cartItems = CartManager.getInstance().getCartItems();
        cartRecyclerView.setAdapter(new wo_salon_adapter(cartItems, requireContext()));
    }
}