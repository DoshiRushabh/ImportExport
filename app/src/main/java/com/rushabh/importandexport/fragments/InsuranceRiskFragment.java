package com.rushabh.importandexport.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rushabh.importandexport.MainActivity;
import com.rushabh.importandexport.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InsuranceRiskFragment extends Fragment implements View.OnClickListener {


    public InsuranceRiskFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_insurance_risk, container, false);

        ((MainActivity) getActivity()).setActionBarTitle("Insurance and Risk Managemrnt");

        v.findViewById(R.id.Link1).setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View view) {
        FragmentTransaction fm = getActivity().getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.trans_left_in, R.anim.trans_left_out, R.anim.trans_right_in, R.anim.trans_right_out)
                .addToBackStack(null);
        WebViewFragment webViewFragment = new WebViewFragment();
        Bundle bundle = new Bundle();
        if (view.getId() == R.id.Link1) {
            bundle.putString("url", "http://www.dnb.com/");
            bundle.putString("title", "Credit Rating Agency");
        }
    }
}
