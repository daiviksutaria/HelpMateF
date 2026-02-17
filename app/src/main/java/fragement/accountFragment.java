package fragement;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.helpmatef.AccountOption;
import com.example.helpmatef.AccountOptionsAdapter;
import com.example.helpmatef.DBHandler;
import com.example.helpmatef.R;
import com.example.helpmatef.UserLoginActivity;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class accountFragment extends Fragment {

    public accountFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_account, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.account_options_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        List<AccountOption> options = Arrays.asList(
                new AccountOption(R.drawable.profile_plan, "My Plans"),
                new AccountOption(R.drawable.profile_wallet, "Wallet"),
                new AccountOption(R.drawable.profile_address, "Manage Addresses"),
                new AccountOption(R.drawable.profile_membership, "Plus Membership"),
                new AccountOption(R.drawable.profile_rate, "My Rating"),
                new AccountOption(R.drawable.profile_payment_method, "Manage Payment Methods"),
                new AccountOption(R.drawable.profile_about_us, "About UC")
        );

        AccountOptionsAdapter adapter = new AccountOptionsAdapter(options);
        recyclerView.setAdapter(adapter);

        TextView nameTextView = view.findViewById(R.id.tv_name);
        TextView emailTextView = view.findViewById(R.id.tv_phone);

        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        String userEmail = sharedPreferences.getString("user_email", null);

        Log.d("ACCOUNT_FRAGMENT", "Retrieved email: " + userEmail);

        if (userEmail != null) {
            DBHandler dbHandler = new DBHandler(requireContext());
            Map<String, String> userDetails = dbHandler.getUserDetails(userEmail.toLowerCase());

            Log.d("ACCOUNT_FRAGMENT", "User details: " + userDetails);

            if (userDetails != null && userDetails.containsKey("name")) {
                Log.d("ACCOUNT_FRAGMENT", "User name: " + userDetails.get("name"));
                nameTextView.setText(userDetails.get("name"));
                emailTextView.setText(userEmail);
            } else {
                Log.d("ACCOUNT_FRAGMENT", "User details not found or name missing.");
                nameTextView.setText("User Details Not Found");
                emailTextView.setText(userEmail);
            }
        } else {
            Log.d("ACCOUNT_FRAGMENT", "User email is null.");
            nameTextView.setText("Guest User");
            emailTextView.setText("");
        }

        Button btnLogout = view.findViewById(R.id.btnLogout);
        if (btnLogout != null) {
            btnLogout.setOnClickListener(v -> logoutUser());
        }
    }

    private void logoutUser() {
        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();

        Intent intent = new Intent(requireActivity(), UserLoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}