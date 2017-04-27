package com.rushabh.importandexport.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rushabh.importandexport.activities.MainActivity;
import com.rushabh.importandexport.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductMarketFragment extends Fragment implements View.OnClickListener {


    public ProductMarketFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_product_market, container, false);

        ((MainActivity) getActivity()).setActionBarTitle("Product and Market selection");
        v.findViewById(R.id.Link1).setOnClickListener(this);
        v.findViewById(R.id.Link2).setOnClickListener(this);
        v.findViewById(R.id.Link3).setOnClickListener(this);
        v.findViewById(R.id.Link4).setOnClickListener(this);
        v.findViewById(R.id.Link6).setOnClickListener(this);
        v.findViewById(R.id.Link7).setOnClickListener(this);
        v.findViewById(R.id.Link8).setOnClickListener(this);
        v.findViewById(R.id.Link9).setOnClickListener(this);
        v.findViewById(R.id.Link10).setOnClickListener(this);
        v.findViewById(R.id.Link11).setOnClickListener(this);
        v.findViewById(R.id.Link12).setOnClickListener(this);
        v.findViewById(R.id.Link13).setOnClickListener(this);
        v.findViewById(R.id.Link16).setOnClickListener(this);
        v.findViewById(R.id.Link17).setOnClickListener(this);
        v.findViewById(R.id.Link18).setOnClickListener(this);
        v.findViewById(R.id.Link19).setOnClickListener(this);
        v.findViewById(R.id.Link20).setOnClickListener(this);
        v.findViewById(R.id.Link21).setOnClickListener(this);
        v.findViewById(R.id.Link22).setOnClickListener(this);
        v.findViewById(R.id.Link23).setOnClickListener(this);
        v.findViewById(R.id.Link24).setOnClickListener(this);
        v.findViewById(R.id.Link25).setOnClickListener(this);
        v.findViewById(R.id.Link26).setOnClickListener(this);
        v.findViewById(R.id.Link260).setOnClickListener(this);
        v.findViewById(R.id.Link28).setOnClickListener(this);
        v.findViewById(R.id.Link30).setOnClickListener(this);
        v.findViewById(R.id.Link34).setOnClickListener(this);
        v.findViewById(R.id.Link35).setOnClickListener(this);
        v.findViewById(R.id.Link36).setOnClickListener(this);
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
            bundle.putString("url", "http://dgft.gov.in/exim/2000/download-ftp1213.htm");
            bundle.putString("title", "Prohibited Products");
        } else if (view.getId() == R.id.Link2) {
            bundle.putString("url", "http://dgft.gov.in/exim/2000/download-ftp1213.htm");
            bundle.putString("title", "Restricted Products");
        } else if (view.getId() == R.id.Link3) {
            bundle.putString("url", "http://10times.com/india/tradeshows");
            bundle.putString("title", "Exhibition & Trade Fairs");
        } else if (view.getId() == R.id.Link4) {
            bundle.putString("url", "http://commerce.nic.in/eidb/default.asp");
            bundle.putString("title", "Export Import Statistics");
        } else if (view.getId() == R.id.Link6) {
            bundle.putString("url", "http://dgft.gov.in/");
            bundle.putString("title", "MEIS - Merchandise Export from India Scheme");
        } else if (view.getId() == R.id.Link7) {
            bundle.putString("url", "www.eximguru.com/hs-codes/default.aspx");
            bundle.putString("title", "Search for H.S. Code");
        } else if (view.getId() == R.id.Link8) {
            bundle.putString("url", "http://www.tradefairdates.com/Fairs-India-Z103-S1.html");
            bundle.putString("title", "Visit Market / Exhibitions");
        } else if (view.getId() == R.id.Link9) {
            bundle.putString("url", "http://www.fieo.org/");
            bundle.putString("title", "Role of FIEO");
        } else if (view.getId() == R.id.Link10) {
            bundle.putString("url", "http://www.eximguru.com/traderesources/exportpromotion.aspx");
            bundle.putString("title", "Export Promotion Councils");
        } else if (view.getId() == R.id.Link11) {
            bundle.putString("url", "https://www.eepcindia.org/");
            bundle.putString("title", "Engineering Goods");
        } else if (view.getId() == R.id.Link12) {
            bundle.putString("url", "https://chemexcil.in/");
            bundle.putString("title", "Chemicals & Cosmetics");
        } else if (view.getId() == R.id.Link13) {
            bundle.putString("url", "http://http://www.capexil.com/");
            bundle.putString("title", "Chemicals & Allied Products");
        } else if (view.getId() == R.id.Link14) {
            bundle.putString("url", "http://www.leatherline.org/trade-rules-and-regulations/india-council-for-leather-export/");
            bundle.putString("title", "Leather Product");
        } else if (view.getId() == R.id.Link16) {
            bundle.putString("url", "http://gjepc.org/");
            bundle.putString("title", "Gems & Jewellery Products");
        } else if (view.getId() == R.id.Link17) {
            bundle.putString("url", "http://www.shellactrade.com/");
            bundle.putString("title", "Shellac Products");
        } else if (view.getId() == R.id.Link18) {
            bundle.putString("url", "http://www.cashewindia.org/");
            bundle.putString("title", "Cashew Products");
        } else if (view.getId() == R.id.Link19) {
            bundle.putString("url", "http://www.plexconcil.org/");
            bundle.putString("title", "Plastic Industry Products");
        } else if (view.getId() == R.id.Link20) {
            bundle.putString("url", "http://www.sportsgoodsindia.org/");
            bundle.putString("title", "Sports Goods Products");
        } else if (view.getId() == R.id.Link21) {
            bundle.putString("url", "http://www.pharmexcil.com/");
            bundle.putString("title", "Pharmaceuticals Products");
        } else if (view.getId() == R.id.Link22) {
            bundle.putString("url", "http://ncti.gov.in/how_do_exports_commodity_boards.php");
            bundle.putString("title", "Commodity Board ");
        } else if (view.getId() == R.id.Link23) {
            bundle.putString("url", "http://rubberboard.org.in/");
            bundle.putString("title", "Rubber Board");
        } else if (view.getId() == R.id.Link24) {
            bundle.putString("url", "http://www.indiacoffee.org/");
            bundle.putString("title", "Coffee Board");
        } else if (view.getId() == R.id.Link25) {
            bundle.putString("url", "http://tobaccoboard.com/");
            bundle.putString("title", "Tobacco Board");
        } else if (view.getId() == R.id.Link26) {
            bundle.putString("url", "http://www.indianspices.com/");
            bundle.putString("title", "Spices Board");
        } else if (view.getId() == R.id.Link260) {
            bundle.putString("url", "http://www.jute.com/");
            bundle.putString("title", "Jute Board");
        } else if (view.getId() == R.id.Link28) {
            bundle.putString("url", "http://apeda.gov.in/apedawebsite/index.html");
            bundle.putString("title", "Agricultural and Processed Food Products Exporter");
        } else if (view.getId() == R.id.Link29) {
            bundle.putString("url", "www.mpeda.gov.in/");
            bundle.putString("url", "Marine Products Export Development Authority");
        } else if (view.getId() == R.id.Link30) {
            bundle.putString("url", "http://www.tradefairdates.com/Fairs-India-Z103-S1.html");
            bundle.putString("title", "Trade Fairs");
        } else if (view.getId() == R.id.Link34) {
            bundle.putString("url", "http://ficci.in/");
            bundle.putString("title", "FICCI");
        } else if (view.getId() == R.id.Link35) {
            bundle.putString("url", "http://www.cii.in/");
            bundle.putString("title", "CII");
        } else if (view.getId() == R.id.Link36) {
            bundle.putString("url", "http://commerce.nic.in/trade/international_ta.asp?id=2&trade=i");
            bundle.putString("title", "Importance of Free Trade Agreements");
        }
        webViewFragment.setArguments(bundle);
        fm.replace(R.id.MainLayout, webViewFragment)
                .commit();
    }
}
