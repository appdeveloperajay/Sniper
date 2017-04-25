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
import com.eroticsniper.Beans.AdvCategoryResp;
import com.eroticsniper.R;

import java.util.ArrayList;

/**
 * Created by joshi on 3/27/2017.
 */

public class AdvanceServiceAdapter extends RecyclerView.Adapter<AdvanceServiceAdapter.MyViewHolder> {

    AdvCategoryResp advCategoryResp;
    Context context;

    public AdvanceServiceAdapter(Context con, AdvCategoryResp adv_CategoryResp) {
        this.advCategoryResp = adv_CategoryResp;
        this.context = con;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_advance_service, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv_adv_ser_name.setText(advCategoryResp.getFilter().get(position).getAdv_service_name());
    }

    @Override
    public int getItemCount() {
        return advCategoryResp.getFilter().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_adv_ser_name;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_adv_ser_name = (TextView) itemView.findViewById(R.id.tv_adv_ser_name);
        }
    }
}
