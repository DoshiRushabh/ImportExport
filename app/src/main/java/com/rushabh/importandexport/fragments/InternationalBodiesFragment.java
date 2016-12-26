package com.rushabh.importandexport.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rushabh.importandexport.MainActivity;
import com.rushabh.importandexport.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InternationalBodiesFragment extends Fragment implements View.OnClickListener {

    public InternationalBodiesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_international_bodies, container, false);

        ((MainActivity) getActivity()).setActionBarTitle("International Bodies");

        v.findViewById(R.id.LinkICC).setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View view) {
        FragmentTransaction fm = getActivity().getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.trans_left_in, R.anim.trans_left_out,R.anim.trans_right_in, R.anim.trans_right_out)
                .addToBackStack(null);
        WebViewFragment webViewFragment = new WebViewFragment();
        Bundle bundle = new Bundle();

        if (view.getId() == R.id.LinkICC){
            bundle.putString("url","http://www.iccwbo.org/");
            bundle.putString("title","ICC");
            webViewFragment.setArguments(bundle);
            fm.replace(R.id.MainLayout,webViewFragment)
                    .commit();
        }
    }
}
