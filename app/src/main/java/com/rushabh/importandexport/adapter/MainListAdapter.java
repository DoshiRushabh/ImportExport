package com.rushabh.importandexport.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rushabh.importandexport.R;
import com.rushabh.importandexport.dataObject.topic;

import java.util.ArrayList;

/**
 * Created by Rushabh on 12/14/2016.
 */

public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.PersonViewHolder> {

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
        topic topic = topicList.get(position);
        holder.title.setText(topic.getTitle());
        holder.description.setText(topic.getDescription());
        Glide.with(context)
                .load(topic.getImage())
                .override(250,250)
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return topicList.size();
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
