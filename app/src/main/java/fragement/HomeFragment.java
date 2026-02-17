package fragement;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.helpmatef.AC_Cleaning_Activity;
import com.example.helpmatef.AC_Repairing_Activity;
import com.example.helpmatef.Electrician_Activity;
import com.example.helpmatef.Home_Cleaning_Activity;
import com.example.helpmatef.Home_Renovation_Activity;
import com.example.helpmatef.In_AC_Service_Activity;
import com.example.helpmatef.in_Architech_Activity;
import com.example.helpmatef.In_Electrician_Plumber_Activity;
import com.example.helpmatef.In_Home_Cleaning_Activity;
import com.example.helpmatef.In_Salon_Activity;
import com.example.helpmatef.Interior_Design_Activity;
import com.example.helpmatef.Mens_Salon_Activity;
import com.example.helpmatef.Plumber_Activity;
import com.example.helpmatef.R;
import com.example.helpmatef.Sofa_Cleaning_Activity;
import com.example.helpmatef.activity_womens_salon;

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Set click listeners for ImageViews and LinearLayouts
        setClickListener(view, R.id.temp_architec, in_Architech_Activity.class);
        setClickListener(view, R.id.template_salon, In_Salon_Activity.class);
        setClickListener(view, R.id.template_home_cleaning, In_Home_Cleaning_Activity.class);
        //setClickListener(view, R.id.templet_ac_service, In_AC_Service_Activity.class);
        //setClickListener(view, R.id.template_electri_plumber, In_Electrician_Plumber_Activity.class);

        setClickListener(view, R.id.image_women_salon, activity_womens_salon.class);
        setClickListener(view, R.id.image_interior_desin, Interior_Design_Activity.class);
        setClickListener(view, R.id.image_home_renorvation, Home_Renovation_Activity.class);
        setClickListener(view, R.id.image_home_clining, Home_Cleaning_Activity.class);
        setClickListener(view, R.id.image_men_salon, Mens_Salon_Activity.class);
        setClickListener(view, R.id.image_sofa_clening, Sofa_Cleaning_Activity.class);
       // setClickListener(view, R.id.image_ac_clening, AC_Cleaning_Activity.class);
        //setClickListener(view, R.id.image_plumber, Plumber_Activity.class);
        //setClickListener(view, R.id.image_ac_repairing, AC_Repairing_Activity.class);
        //setClickListener(view, R.id.image_sofa_clening, Sofa_Cleaning_Activity.class);

        return view;
    }

    private void setClickListener(View view, int viewId, Class<?> activityClass) {
        View item = view.findViewById(viewId);
        if (item != null) {
            item.setOnClickListener(v -> startActivity(new Intent(getActivity(), activityClass)));
        }
    }
}
