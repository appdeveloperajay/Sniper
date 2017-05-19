package com.eroticsniper.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.eroticsniper.AddLocaton;
import com.eroticsniper.AdvanceCategory;
import com.eroticsniper.Beans.Retroresponse;
import com.eroticsniper.Global;
import com.eroticsniper.R;

import java.util.ArrayList;

/**
 * Created by joshi on 3/27/2017.
 */

public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.MyViewHolder> {
    String TAG = "SERVICEADAPTER";
    String have_advance_services;
    Context context;
    String catid;
    Retroresponse response;

    public ServicesAdapter(Context con, Retroresponse response1, String catId, String have_advance_services) {
        this.catid = catId;
        this.response = response1;
        this.have_advance_services = have_advance_services;
        this.context = con;
        Log.d(TAG, "have_advance_services:- " + have_advance_services);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_services_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.txt_category.setText(response.getServices().get(position).getService_name());
        holder.RL_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(have_advance_services) == 1) {
                    Intent i = new Intent().setClass(context, AdvanceCategory.class);
                    context.startActivity(i);
                } else {
                    Intent i = new Intent().setClass(context, AddLocaton.class);
                    context.startActivity(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return response.getServices().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt_category;
        RelativeLayout RL_service;

        public MyViewHolder(View itemView) {
            super(itemView);
            txt_category = (TextView) itemView.findViewById(R.id.txt_category);
            RL_service = (RelativeLayout) itemView.findViewById(R.id.RL_service);
        }
    }
}
