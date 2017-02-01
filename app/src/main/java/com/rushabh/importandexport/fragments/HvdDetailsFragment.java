package com.rushabh.importandexport.fragments;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.rushabh.importandexport.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HvdDetailsFragment extends Fragment implements View.OnClickListener {

    LinearLayout callUs,mailUs;
    public HvdDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_hvd_details, container, false);

            callUs = (LinearLayout) v.findViewById(R.id.callus);
            mailUs = (LinearLayout) v.findViewById(R.id.mailus);

            callUs.setOnClickListener(this);
            mailUs.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.callus){
            if (checkPermission()){
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:+919825774075"));
                startActivity(callIntent);
            }
        }else if(view.getId() == R.id.mailus){
            Intent Email = new Intent(Intent.ACTION_SEND);
            Email.setType("text/email");
            Email.putExtra(Intent.EXTRA_EMAIL, new String[] { "hvdinternational@gmail.com" });
            Email.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
            Email.putExtra(Intent.EXTRA_TEXT, " ");
            startActivity(Intent.createChooser(Email, "Send Feedback:"));
        }
    }

    boolean checkPermission() {
        int permissionCheckStorage = ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.CALL_PHONE);
        if (permissionCheckStorage == PackageManager.PERMISSION_DENIED) {
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 123);
            Toast.makeText(getActivity(), "Need permission to make a call", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
