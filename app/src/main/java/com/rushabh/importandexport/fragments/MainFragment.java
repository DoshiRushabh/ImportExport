package com.rushabh.importandexport.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rushabh.importandexport.activities.MainActivity;
import com.rushabh.importandexport.R;
import com.rushabh.importandexport.adapter.MainListAdapter;
import com.rushabh.importandexport.dataObject.topic;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private ArrayList<topic> topicList;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        ((MainActivity) getActivity()).setActionBarTitle("Import and Export");

        initializeDummyData();

        RecyclerView rv = (RecyclerView) v.findViewById(R.id.rv);
        rv.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(v.getContext());
        rv.setLayoutManager(llm);

        MainListAdapter adapter = new MainListAdapter(topicList, v.getContext());
        rv.setAdapter(adapter);

        return v;
    }

    private void initializeDummyData() {
        topicList = new ArrayList<>();
        topicList.add(new topic(R.drawable.introduction, "Introduction", "Welcomes you to the exciting world of Import-Export.There are so many opportunities in Import-Export sector.\n"));
        topicList.add(new topic(R.drawable.internationalbodies, "International Bodies", "Information about bodies and it's framework"));
        topicList.add(new topic(R.drawable.importexportcycles, "Import Export Cycle", "IE cycle from company formation to delivery"));
        topicList.add(new topic(R.drawable.importexportbasics, "Import Export Basics", "Basic knowledge about Import and Export"));
        topicList.add(new topic(R.drawable.modeoftransport, "Modes of Transport", "Transport your Goods with various transportation mode like sea air & road"));
        topicList.add(new topic(R.drawable.foreigntrade, "Foreign Trade", "World's Import and Export rules and instruction"));
        topicList.add(new topic(R.drawable.incoterms, "Incoterms", "Know the terms for delivery , packing and cost"));
        topicList.add(new topic(R.drawable.importdocument, "LC Check List & Export Documentation", "Prepare te document required for export"));
        topicList.add(new topic(R.drawable.payment, "Payment Terms", "How to do payment , select the secure payment from various types of payment terms"));
        topicList.add(new topic(R.drawable.productandmarcet, "Product And Market Selection", "How to select the product and market"));
        topicList.add(new topic(R.drawable.identifyingbuyer, "Identifying Buyers", "Find the buyers offline and online , Select the buyer , communicate and verify"));
        topicList.add(new topic(R.drawable.insuranceandrisk, "Insurance and Risk Management", "Types of risk and various insurance to cover risks"));
        topicList.add(new topic(R.drawable.govermentbenifit, "Government Benefits", "Get the benefit from  government for export Import"));
        topicList.add(new topic(R.drawable.documantation, "Import Document", "Process of Import and it's documentation"));
    }
}
