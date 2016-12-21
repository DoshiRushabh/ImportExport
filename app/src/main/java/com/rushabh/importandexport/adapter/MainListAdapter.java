package com.rushabh.importandexport.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.rushabh.importandexport.R;
import com.rushabh.importandexport.activities.ForignTradeActivity;
import com.rushabh.importandexport.activities.GovermentBenefitsActivity;
import com.rushabh.importandexport.activities.IdentifyingBuyersPaymentActivity;
import com.rushabh.importandexport.activities.ImportDocumentActivity;
import com.rushabh.importandexport.activities.ImportExportBasicsActivity;
import com.rushabh.importandexport.activities.ImportExportCycleSctivity;
import com.rushabh.importandexport.activities.IncotermsActivity;
import com.rushabh.importandexport.activities.InsuAndRiskActivity;
import com.rushabh.importandexport.activities.InternationalBodiesActivity;
import com.rushabh.importandexport.activities.LcChecklistActivity;
import com.rushabh.importandexport.activities.ModeOfTransActivity;
import com.rushabh.importandexport.activities.PaymentTermsActivity;
import com.rushabh.importandexport.activities.ProductMarcetSelectActivity;
import com.rushabh.importandexport.activities.introActivity;
import com.rushabh.importandexport.dataObject.topic;

import java.util.ArrayList;

/**
 * Created by Rushabh on 12/14/2016.
 */

public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.PersonViewHolder> implements View.OnClickListener {

    private ArrayList<topic> topicList;
    private Context context;

    public MainListAdapter(ArrayList<topic> topicList, Context context) {
        this.topicList = topicList;
        this.context = context;
    }

    @Override
    public MainListAdapter.PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.topic_list_card, parent, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(MainListAdapter.PersonViewHolder holder, int position) {
//        Clear animation
        holder.itemView.clearAnimation();
//        Creating new animation
        int lastPosition = -1;
        Animation animation = AnimationUtils.loadAnimation(context,
                (position > lastPosition) ? R.anim.up_from_bottom
                        : R.anim.down_from_top);
        holder.itemView.startAnimation(animation);
        lastPosition = position;

        topic topic = topicList.get(position);
        holder.title.setText(topic.getTitle());
        holder.description.setText(topic.getDescription());
        Glide.with(context)
                .load(topic.getImage())
                .override(250,250)
                .into(holder.image);
        holder.cv.setTag(R.string.app_name,position);
        holder.cv.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return topicList.size();
    }

    @Override
    public void onClick(View view) {
        int position = (int) view.getTag(R.string.app_name);
//        position start from 0

        switch (position){
            case 0:
                context.startActivity(new Intent(context,introActivity.class));
                return;
            case 1:
                context.startActivity(new Intent(context,InternationalBodiesActivity.class));
                return;
            case 2:
                context.startActivity(new Intent(context,ImportExportCycleSctivity.class));
                return;
            case 3:
                context.startActivity(new Intent(context,ImportExportBasicsActivity.class));
                return;
            case 4:
                context.startActivity(new Intent(context,ModeOfTransActivity.class));
                return;
            case 5:
                context.startActivity(new Intent(context,ForignTradeActivity.class));
                return;
            case 6:
                context.startActivity(new Intent(context,IncotermsActivity.class));
                return;
            case 7:
                context.startActivity(new Intent(context,LcChecklistActivity.class));
                return;
            case 8:
                context.startActivity(new Intent(context,PaymentTermsActivity.class));
                return;
            case 9:
                context.startActivity(new Intent(context,ProductMarcetSelectActivity.class));
                return;
            case 10:
                context.startActivity(new Intent(context,IdentifyingBuyersPaymentActivity.class));
                return;
            case 11:
                context.startActivity(new Intent(context,InsuAndRiskActivity.class));
                return;
            case 12:
                context.startActivity(new Intent(context,GovermentBenefitsActivity.class));
                return;
            case 13:
                context.startActivity(new Intent(context,ImportDocumentActivity.class));
                return;
            default:
                return;

        }
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder {
        TextView title,description;
        ImageView image;
        CardView cv;
        public PersonViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);
            image = (ImageView) itemView.findViewById(R.id.image);
            cv = (CardView) itemView.findViewById(R.id.cv);
        }
    }
}
