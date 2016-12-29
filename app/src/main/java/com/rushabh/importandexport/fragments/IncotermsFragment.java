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
public class IncotermsFragment extends Fragment implements View.OnClickListener {


    public IncotermsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_incoterms, container, false);

        ((MainActivity) getActivity()).setActionBarTitle("Incoterms");
        v.findViewById(R.id.Link1).setOnClickListener(this);
        v.findViewById(R.id.Link2).setOnClickListener(this);
        v.findViewById(R.id.Link3).setOnClickListener(this);
        v.findViewById(R.id.Link4).setOnClickListener(this);
        v.findViewById(R.id.Link5).setOnClickListener(this);
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
            bundle.putString("url", "https://www.export.gov/export-faqs");
            bundle.putString("title", "What is INCOTERMS?");
        } else if (view.getId() == R.id.Link2) {
            bundle.putString("url", "http://www.worldportsource.com/countries.php");
            bundle.putString("title", "SEA PORT");
        } else if (view.getId() == R.id.Link3) {
            bundle.putString("url", "http://www.cybex.in/Indian-Ports-Data.aspx");
            bundle.putString("title", "AIR PORT");
        } else if (view.getId() == R.id.Link4) {
            bundle.putString("url", "http://commerce.nic.in/trade/icd_list.pdf");
            bundle.putString("title", "DRY PORT ");
        } else if (view.getId() == R.id.Link5) {
            bundle.putString("url", "http://www.eximguru.com/exim/guides/export-finance/ch_3_letter_of_credit_lc.aspx");
            bundle.putString("title", "Introduction of Letter of Credit (L/C)");
        }
        webViewFragment.setArguments(bundle);
        fm.replace(R.id.MainLayout, webViewFragment)
                .commit();
    }
}
