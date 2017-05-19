package com.eroticsniper.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.eroticsniper.AdvanceCategory;
import com.eroticsniper.Beans.AdvCategoryResp;
import com.eroticsniper.Global;
import com.eroticsniper.R;
import com.eroticsniper.Services;

import java.util.ArrayList;

/**
 * Created by joshi on 3/27/2017.
 */

public class AdvaceServiceDialogAdapter extends RecyclerView.Adapter<AdvaceServiceDialogAdapter.MyViewHolder> {
    AdvCategoryResp advCategoryResp;
    Context mContext;
    int pos;

    public AdvaceServiceDialogAdapter(Context context, AdvCategoryResp adv_CategoryResp, int position) {
        this.advCategoryResp = adv_CategoryResp;
        this.pos = position;
        this.mContext = context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_dialog_adapter, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        if (AdvanceCategory.selectedIds.contains(Integer.parseInt(advCategoryResp.getFilter().get(pos).getAdv_service_options().get(position).getOption_id()))) {
//            Log.d("arraylistscategory", "true" + advCategoryResp.getFilter().get(position).getAdv_service_id());
            holder.checkbox.setChecked(true);
        } else {
//            Log.d("arraylistscategory", false + advCategoryResp.getFilter().get(position).getAdv_service_id());
            holder.checkbox.setChecked(false);
        }


        holder.tv_option_name.setText(advCategoryResp.getFilter().get(pos).getAdv_service_options().get(position).getOption_Name());
        holder.Ll_full_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.checkbox.isChecked() == true) {
                    if (AdvanceCategory.selectedIds.contains(Integer.parseInt(advCategoryResp.getFilter().get(pos).getAdv_service_options().get(position).getOption_id()))) {
                        Log.d("arraylistscategory", "contains"+ AdvanceCategory.selectedIds.size() );
                        for (int i = AdvanceCategory.selectedIds.size() - 1; i >= 0; i--) {
                            Log.d("arraylistscategory", "id array " + AdvanceCategory.selectedIds.get(i)+" selected "+advCategoryResp.getFilter().get(pos).getAdv_service_options().get(position).getOption_id());
                            if (AdvanceCategory.selectedIds.get(i) == Integer.parseInt(advCategoryResp.getFilter().get(pos).getAdv_service_options().get(position).getOption_id()))
                            {
                                AdvanceCategory.selectedIds.remove(i);
                            }
                        }

                    }

                } else {
                    AdvanceCategory.selectedIds.add(Integer.parseInt(advCategoryResp.getFilter().get(pos).getAdv_service_options().get(position).getOption_id()));
                }
                notifyDataSetChanged();


            }
        });
    }

    @Override
    public int getItemCount() {
        return advCategoryResp.getFilter().get(pos).getAdv_service_options().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkbox;
        TextView tv_option_name;
        LinearLayout Ll_full_row;

        public MyViewHolder(View itemView) {
            super(itemView);
            checkbox = (CheckBox) itemView.findViewById(R.id.checkbox);
            checkbox.setFocusable(false);
            checkbox.setClickable(false);
            tv_option_name = (TextView) itemView.findViewById(R.id.tv_option_name);
            Ll_full_row = (LinearLayout) itemView.findViewById(R.id.Ll_full_row);
        }
    }
}
