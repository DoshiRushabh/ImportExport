package com.rushabh.importandexport.adapter;

import android.content.Context;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rushabh.importandexport.MainActivity;
import com.rushabh.importandexport.R;
import com.rushabh.importandexport.dataObject.topic;
import com.rushabh.importandexport.fragments.ForignTradeFragment;
import com.rushabh.importandexport.fragments.GovermentBenefitsFragment;
import com.rushabh.importandexport.fragments.IdentifyingBuyerFragment;
import com.rushabh.importandexport.fragments.ImportDocumentFragment;
import com.rushabh.importandexport.fragments.ImportExportBasicsFragment;
import com.rushabh.importandexport.fragments.ImportExportCycleFragment;
import com.rushabh.importandexport.fragments.IncotermsFragment;
import com.rushabh.importandexport.fragments.InsuranceRiskFragment;
import com.rushabh.importandexport.fragments.InternationalBodiesFragment;
import com.rushabh.importandexport.fragments.IntroFragment;
import com.rushabh.importandexport.fragments.LcChecklistFragment;
import com.rushabh.importandexport.fragments.ModeOfTransportFragment;
import com.rushabh.importandexport.fragments.PaymentTermsFragment;
import com.rushabh.importandexport.fragments.ProductMarketFragment;

import java.util.ArrayList;

/**
 * Created by Rushabh on 12/14/2016.
 */

public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.PersonViewHolder> implements View.OnClickListener {

    LinearLayout MainLayout;
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

//        ((MainActivity) context).getSupportFragmentManager()

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


        MainActivity myActivity = (MainActivity) context;
        MainLayout = (LinearLayout) ((MainActivity) context).findViewById(R.id.MainLayout);

        FragmentTransaction fm = ((MainActivity) context).getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.trans_left_in, R.anim.trans_left_out,R.anim.trans_right_in, R.anim.trans_right_out)
                .addToBackStack(null);

        switch (position){
            case 0:
                fm.replace(R.id.MainLayout,new IntroFragment())
                        .commit();
                return;
            case 1:
//                context.startActivity(new Intent(context,InternationalBodiesActivity.class));
                fm.replace(R.id.MainLayout,new InternationalBodiesFragment())
                        .commit();
                return;
            case 2:
//                context.startActivity(new Intent(context,ImportExportCycleSctivity.class));
                fm.replace(R.id.MainLayout,new ImportExportCycleFragment())
                        .commit();
                return;
            case 3:
//                context.startActivity(new Intent(context,ImportExportBasicsActivity.class));
                fm.replace(R.id.MainLayout,new ImportExportBasicsFragment())
                        .commit();
                return;
            case 4:
//                context.startActivity(new Intent(context,ModeOfTransActivity.class));
                fm.replace(R.id.MainLayout,new ModeOfTransportFragment())
                        .commit();
                return;
            case 5:
//                context.startActivity(new Intent(context,ForignTradeActivity.class));
                fm.replace(R.id.MainLayout,new ForignTradeFragment())
                        .commit();
                return;
            case 6:
//                context.startActivity(new Intent(context,IncotermsActivity.class));
                fm.replace(R.id.MainLayout,new IncotermsFragment())
                        .commit();
                return;
            case 7:
//                context.startActivity(new Intent(context,LcChecklistActivity.class));
                fm.replace(R.id.MainLayout,new LcChecklistFragment())
                        .commit();
                return;
            case 8:
//                context.startActivity(new Intent(context,PaymentTermsActivity.class));
                fm.replace(R.id.MainLayout,new PaymentTermsFragment())
                        .commit();
                return;
            case 9:
//                context.startActivity(new Intent(context,ProductMarcetSelectActivity.class));
                fm.replace(R.id.MainLayout,new ProductMarketFragment())
                        .commit();
                return;
            case 10:
//                context.startActivity(new Intent(context,IdentifyingBuyersPaymentActivity.class));
                fm.replace(R.id.MainLayout,new IdentifyingBuyerFragment())
                        .commit();
                return;
            case 11:
//                context.startActivity(new Intent(context,InsuAndRiskActivity.class));
                fm.replace(R.id.MainLayout,new InsuranceRiskFragment())
                        .commit();
                return;
            case 12:
//                context.startActivity(new Intent(context,GovermentBenefitsActivity.class));
                fm.replace(R.id.MainLayout,new GovermentBenefitsFragment())
                        .commit();
                return;
            case 13:
//                context.startActivity(new Intent(context,ImportDocumentActivity.class));
                fm.replace(R.id.MainLayout,new ImportDocumentFragment())
                        .commit();
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
