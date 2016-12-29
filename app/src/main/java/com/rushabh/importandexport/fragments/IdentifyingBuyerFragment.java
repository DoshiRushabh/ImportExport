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
public class IdentifyingBuyerFragment extends Fragment implements View.OnClickListener {


    public IdentifyingBuyerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_identifying_buyer, container, false);

        ((MainActivity) getActivity()).setActionBarTitle("Identifying Buyer");
        v.findViewById(R.id.Link1).setOnClickListener(this);
        v.findViewById(R.id.Link2).setOnClickListener(this);
        v.findViewById(R.id.Link3).setOnClickListener(this);
        v.findViewById(R.id.Link4).setOnClickListener(this);
        v.findViewById(R.id.Link5).setOnClickListener(this);
        v.findViewById(R.id.Link6).setOnClickListener(this);

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
            bundle.putString("url", "http://www.tradefairdates.com/Fairs-India-Z103-S1.html");
            bundle.putString("title", "Participation in Exhibition / Trade Fairs");
        } else if (view.getId() == R.id.Link2) {
            bundle.putString("url", "http://commerce.gov.in/DOC/index.aspx");
            bundle.putString("title", "Databases from Govt. Trade Promotion Bodies");
        } else if (view.getId() == R.id.Link3) {
            bundle.putString("url", "http://http://ww2.worldwidetradeleads.com/?folio=9POR7JU99");
            bundle.putString("title", "List of Trade Directories World Wide");
        } else if (view.getId() == R.id.Link4) {
            bundle.putString("url", "http://www.yellowpages.in/");
            bundle.putString("title", "Yellow Pages - http://www.yellowpages.in/");
        } else if (view.getId() == R.id.Link5) {
            bundle.putString("url", "www.b2bbyte.com");
            bundle.putString("title", "List of Top B2B Websites Worldwide:");
        }
        else if (view.getId() == R.id.Link6) {
            bundle.putString("url", "Indian Embassy Abroad “OUR FIRST RELATIVE”");
            bundle.putString("title", "http://www.indiaonlinepages.com/indian-embassies-abroad.html");
        }
        webViewFragment.setArguments(bundle);
        fm.replace(R.id.MainLayout, webViewFragment)
                .commit();
    }
}
