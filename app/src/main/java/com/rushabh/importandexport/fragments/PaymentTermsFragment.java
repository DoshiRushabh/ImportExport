package com.rushabh.importandexport.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rushabh.importandexport.activities.MainActivity;
import com.rushabh.importandexport.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PaymentTermsFragment extends Fragment {


    public PaymentTermsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_payment_terms, container, false);

        ((MainActivity) getActivity()).setActionBarTitle("Payment Terms");

        return v;
    }

}
