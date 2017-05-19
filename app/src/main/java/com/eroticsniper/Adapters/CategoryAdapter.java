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

import com.eroticsniper.Beans.CategoryResp;
import com.eroticsniper.Global;
import com.eroticsniper.R;
import com.eroticsniper.Services;

import java.util.ArrayList;

/**
 * Created by joshi on 3/27/2017.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    String TAG = "Category_Adapter";

    Context mContext;
    CategoryResp category;

    public CategoryAdapter(Context context, CategoryResp category) {
        this.category = category;
        this.mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_category_layout, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        Log.d(TAG, "****************start********************");
        Log.d(TAG, "Category id:-" + category.getCategory().get(position).getCat_id());
        Log.d(TAG, "Have_services:-" + category.getCategory().get(position).getHave_services());
        Log.d(TAG, "Have_advanceservices:-" + category.getCategory().get(position).getHave_advanceservices());
        Log.d(TAG, "****************stop********************");

        holder.txt_category.setText(category.getCategory().get(position).getCat_name());
        holder.Rl_fullRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (category.getCategory().get(position).getHave_services().trim().equals("1")) {
                    Global.CatId = category.getCategory().get(position).getCat_id();
                    Global.HaveAdvanceServices = category.getCategory().get(position).getHave_advanceservices();

                    Intent i = new Intent().setClass(mContext, Services.class);
                    mContext.startActivity(i);
                } else {

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return category.getCategory().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt_category;
        RelativeLayout Rl_fullRow;

        public MyViewHolder(View itemView) {
            super(itemView);
            txt_category = (TextView) itemView.findViewById(R.id.txt_category);
            Rl_fullRow = (RelativeLayout) itemView.findViewById(R.id.Rl_fullRow);
        }
    }
}
