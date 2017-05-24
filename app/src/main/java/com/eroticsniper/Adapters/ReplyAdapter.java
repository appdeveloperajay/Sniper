package com.eroticsniper.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.eroticsniper.R;

import java.util.ArrayList;


/**
 * Created by bhushan on 11-02-2017.
 */


public class ReplyAdapter extends RecyclerView.Adapter<ReplyAdapter.MyViewHolder> {
    ArrayList<String> userid;
    ArrayList<String> username;
    ArrayList<String> reply;
    ArrayList<String> time;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView Name, reply, time;

        public MyViewHolder(View view) {
            super(view);
            Name = (TextView) view.findViewById(R.id.tv_name);
            reply = (TextView) view.findViewById(R.id.tv_reply_text);
            time = (TextView) view.findViewById(R.id.tv_time);
        }
    }


    public ReplyAdapter(Context context, ArrayList<String> userid, ArrayList<String> name, ArrayList<String> reply, ArrayList<String> Time) {
        this.context = context;
        this.userid = userid;
        this.username = name;
        this.reply = reply;
        this.time = Time;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.reply_adapter, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.Name.setText(userid.get(position));
        holder.reply.setText(reply.get(position));
        holder.time.setText(time.get(position));

    }

    @Override
    public int getItemCount() {
        return userid.size();
    }
}
