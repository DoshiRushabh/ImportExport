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
public class ImportDocumentFragment extends Fragment implements View.OnClickListener {


    public ImportDocumentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_import_document, container, false);

        ((MainActivity) getActivity()).setActionBarTitle("Import Document");
        v.findViewById(R.id.Link1).setOnClickListener(this);
        v.findViewById(R.id.Link2).setOnClickListener(this);

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
            bundle.putString("url", "http://dgftcom.nic.in/exim/2000/policy/chap-04.htm");
            bundle.putString("title", "Advance License");
        } else if (view.getId() == R.id.Link2) {
            bundle.putString("url", "http://howtoexportimport.com/Service-Exports-from-India-Scheme-SEIS--1566.aspx");
            bundle.putString("title", "Serve From India");
        }
        webViewFragment.setArguments(bundle);
        fm.replace(R.id.MainLayout, webViewFragment)
                .commit();
    }
}
