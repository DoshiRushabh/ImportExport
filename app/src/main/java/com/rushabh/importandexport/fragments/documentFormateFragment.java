package com.rushabh.importandexport.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rushabh.importandexport.R;
import com.rushabh.importandexport.activities.MainActivity;
import com.rushabh.importandexport.adapter.documentsAdapter;
import com.rushabh.importandexport.dataObject.topic;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class documentFormateFragment extends Fragment {


    public documentFormateFragment() {
        // Required empty public constructor
    }

    View v;
    RecyclerView rv;
    private ArrayList<topic> topicList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_document_formate, container, false);

        ((MainActivity) getActivity()).setActionBarTitle("Document formate");

        rv = (RecyclerView) v.findViewById(R.id.rv);

        initializeData();

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(v.getContext()));
        rv.setAdapter(new documentsAdapter(topicList,v.getContext()));
        return v;
    }

    private void initializeData() {
        topicList = new ArrayList<>();
        topicList.add(new topic(R.drawable.introduction, "Commercial Invoice", "commercial_invoice.xls"));
        topicList.add(new topic(R.drawable.internationalbodies, "Indeminity Letter", "indeminity_letter.xls"));
        topicList.add(new topic(R.drawable.importexportcycles, "Non DG Declaration", "non_dg_declaration.xls"));
        topicList.add(new topic(R.drawable.importexportbasics, "Packing list", "packing_list.xls"));
        topicList.add(new topic(R.drawable.modeoftransport, "Proforma invoice formate", "proforma_invoice_format.xls"));
        topicList.add(new topic(R.drawable.foreigntrade, "SDF form", "sdf_form.xls"));
        topicList.add(new topic(R.drawable.incoterms, "Single country declaration", "single_country_declaration.xls"));
    }

}
