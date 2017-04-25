package com.eroticsniper.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.eroticsniper.AdvanceCategory;
import com.eroticsniper.R;

import java.util.ArrayList;

/**
 * Created by joshi on 3/27/2017.
 */

public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.MyViewHolder> {

    ArrayList<String> ServiceName;
    ArrayList<String> ServiceId;
    String have_advance_services;
    Context context;

    public ServicesAdapter(Context con, ArrayList<String> ServiceId, ArrayList<String> ServiceName, String HaveAdvanceServices) {
        this.ServiceName = ServiceName;
        this.ServiceId = ServiceId;
        this.have_advance_services = HaveAdvanceServices;
        this.context = con;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_services_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.txt_category.setText(ServiceName.get(position));
        holder.RL_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(have_advance_services) == 1) {
                    Intent i = new Intent().setClass(context, AdvanceCategory.class);
                    context.startActivity(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return ServiceName.size();
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
