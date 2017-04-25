package com.eroticsniper.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.eroticsniper.Global;
import com.eroticsniper.R;
import com.eroticsniper.Services;

import java.util.ArrayList;

/**
 * Created by joshi on 3/27/2017.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {


    ArrayList<String> RESCategory = new ArrayList<String>();
    ArrayList<String> RESCategoryId = new ArrayList<String>();
    ArrayList<String> Cat_type = new ArrayList<String>();
    ArrayList<String> Have_services = new ArrayList<String>();
    ArrayList<String> Have_advanceservices = new ArrayList<String>();
    Context mContext;

    public CategoryAdapter(Context context, ArrayList<String> category, ArrayList<String> categoryId, ArrayList<String> cat_type, ArrayList<String> have_services, ArrayList<String> have_advanceservices) {
        this.RESCategory = category;
        this.RESCategoryId = categoryId;
        this.Have_advanceservices = have_advanceservices;
        this.Cat_type = cat_type;
        this.Have_services = have_services;
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

        holder.txt_category.setText(RESCategory.get(position));
        holder.Rl_fullRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(mContext, ""+Have_services, Toast.LENGTH_SHORT).show();
                if (Have_services.get(position).toString().trim().equals("1")) {
//                    Toast.makeText(mContext, "cat" + Have_advanceservices.get(position).toString(), Toast.LENGTH_SHORT).show();
                    Global.CatId = RESCategoryId.get(position);
                    Intent i = new Intent().setClass(mContext, Services.class);
                    i.putExtra("adv_service", Have_advanceservices.get(position).toString());
                    mContext.startActivity(i);
                } else if (Have_advanceservices.get(position).toString().trim().equals(1)) {


                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return RESCategory.size();
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
