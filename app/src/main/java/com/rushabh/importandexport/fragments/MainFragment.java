package com.rushabh.importandexport.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        topicList.add(new topic(R.drawable.introduction, "Introduction", "Welcomes you to the exciting world of Import-Export.There are so many opportunities in Import-Export sector.\n" +
                "This setion give you the basic knowledge about Import-Export & it's very useful to you in this sector."));
        topicList.add(new topic(R.drawable.internationalbodies, "International Bodies", "This section provide information about available international & indian bodies, agencies, organization & board for import-export.\n" +
                "It also gives you the details about Foreign Trade Policy and Indian Government Laws."));
        topicList.add(new topic(R.drawable.importexportcycles, "Import Export Cycle", "This section provide information about import-export licence & import-export cycle and importance about import-export licence."));
        topicList.add(new topic(R.drawable.importexportbasics, "Import Export Basics", "This section provide information about import-export incoterms, types of ports, types of packing & international payment terms."));
        topicList.add(new topic(R.drawable.modeoftransport, "Modes of Transport", "This section provide information about differnet-different types of transportation, methods of dispatch, containers, freight rates & other modes."));
        topicList.add(new topic(R.drawable.foreigntrade, "Foregin Trade", "This section provide information about GDP growth world map, reason of exports, world's leading importer & exporter, institutions, Trade institutions, various rules & acts, career opporunities & export process."));
        topicList.add(new topic(R.drawable.incoterms, "Incoterms", "This section provide information about International Commercial Terms in details, various definitions, various terms & conditions."));
        topicList.add(new topic(R.drawable.importdocument, "LC Check List & Export Documentation", "This section provide information about L/C Checklist & Export Documentation, various shipment documentation."));
        topicList.add(new topic(R.drawable.payment, "Payment Terms", "This section provide information about various types of payment terms, status holders."));
        topicList.add(new topic(R.drawable.productandmarcet, "Product And Market Selection", "This section provide information about international marketing for various product, product selection & market selection."));
        topicList.add(new topic(R.drawable.identifyingbuyer, "Identifying Buyers", "This section provide information about international marketing for various product, product selection & market selection."));
        topicList.add(new topic(R.drawable.insuranceandrisk, "Insurance and Risk Management", "This section provide information about insurance of product, risk management & types of risk."));
        topicList.add(new topic(R.drawable.govermentbenifit, "Goverment Benefits", "This section provide information about government benefits & incentives for import-export, government various types benefits on exports."));
        topicList.add(new topic(R.drawable.documantation, "Import Document", "This section provide information about important documentation, registration of importers, identification of supplier, important aspects of import contract & payment formalities."));
    }
}
