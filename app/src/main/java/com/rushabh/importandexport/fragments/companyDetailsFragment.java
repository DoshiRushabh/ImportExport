package com.rushabh.importandexport.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.rushabh.importandexport.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class companyDetailsFragment extends Fragment implements View.OnClickListener {

    LinearLayout mailUs;
    public companyDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_company_details, container, false);

        mailUs = (LinearLayout) v.findViewById(R.id.mailus);
        mailUs.setOnClickListener(this);

        return v;
    }


    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.mailus){
            Intent Email = new Intent(Intent.ACTION_SEND);
            Email.setType("text/email");
            Email.putExtra(Intent.EXTRA_EMAIL, new String[] { "developersicode@gmail.com" });
            Email.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
            Email.putExtra(Intent.EXTRA_TEXT, " ");
            startActivity(Intent.createChooser(Email, "Send Feedback:"));
        }
    }
}
