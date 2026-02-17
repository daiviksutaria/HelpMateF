package com.example.helpmatef;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BookingFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_booking, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RadioGroup paymentOptions = view.findViewById(R.id.paymentOptions);
        Button proceedButton = view.findViewById(R.id.btnProceedPayment);

        proceedButton.setOnClickListener(v -> {
            int selectedId = paymentOptions.getCheckedRadioButtonId();

            if (selectedId == R.id.radioCashOnService) {
                // Open new activity for Cash on Service
                Intent intent = new Intent(requireContext(), activity_cash_on_service.class);
                startActivity(intent);
            } else {
                String url = "";

                if (selectedId == R.id.radioGooglePay) {
                    url = "https://pay.google.com/about/";
                } else if (selectedId == R.id.radioPaytm) {
                    url = "https://business.paytm.com/";
                }

                if (!url.isEmpty()) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                }
            }
        });
    }
}
