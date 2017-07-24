package com.rushabh.importandexport.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.rushabh.importandexport.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HelpUsFragment extends Fragment implements View.OnClickListener {

    private InterstitialAd interstitialAd;
    private Button showAd;

    public HelpUsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_help_us, container, false);

        showAd = (Button) v.findViewById(R.id.showAd);

        showAd.setOnClickListener(this);

        interstitialAd = new InterstitialAd(getActivity());
        interstitialAd.setAdUnitId(getResources().getString(R.string.help_us_out_adsid));

        LoadAd();

        return v;
    }

    private void LoadAd() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
//                .addTestDevice("534E961287FF5EE75719F93E605436E6")
//                .addTestDevice("B71EDBE67DDC4536B8DEC45FD2F0CC6F")
                .build();
        interstitialAd.loadAd(adRequest);

        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                showAd.setEnabled(true);
                showAd.setText("Show Ad");
            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
                LoadAd();
                showAd.setEnabled(false);
                showAd.setText("loading ad....");
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.showAd) {
            if (interstitialAd.isLoaded()) {
                interstitialAd.show();
            }
        }
    }
}
