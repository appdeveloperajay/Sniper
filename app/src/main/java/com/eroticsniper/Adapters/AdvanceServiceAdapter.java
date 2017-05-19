package com.eroticsniper.Adapters;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
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
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tv_adv_ser_name.setText(advCategoryResp.getFilter().get(position).getAdv_service_name());
        holder.Ll_full_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog d = new Dialog(context);
                d.setCancelable(false);
                d.setContentView(R.layout.custom_dialog);
                Button btn_cancel = (Button) d.findViewById(R.id.btn_cancel);
                btn_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        d.dismiss();
                    }
                });

                Button btn_ok = (Button) d.findViewById(R.id.btn_ok);
                btn_ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        d.dismiss();
                    }
                });

                RecyclerView Rv_items = (RecyclerView) d.findViewById(R.id.Rv_items);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
                Rv_items.setLayoutManager(mLayoutManager);
                Rv_items.setItemAnimator(new DefaultItemAnimator());
                AdvaceServiceDialogAdapter advaceServiceDialogAdapter = new AdvaceServiceDialogAdapter(context, advCategoryResp, position);
                Rv_items.setAdapter(advaceServiceDialogAdapter);


                d.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return advCategoryResp.getFilter().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_adv_ser_name;
        LinearLayout Ll_full_row;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_adv_ser_name = (TextView) itemView.findViewById(R.id.tv_adv_ser_name);
            Ll_full_row = (LinearLayout) itemView.findViewById(R.id.Ll_full_row);
        }
    }
}
