package com.eroticsniper;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;


import com.eroticsniper.Adapters.ReplyAdapter;
import com.eroticsniper.Database.Database;

import java.util.ArrayList;

public class Replies extends AppCompatActivity {
    Database db;
    ArrayList<String> userid;
    ArrayList<String> username;
    ArrayList<String> reply;
    ArrayList<String> time;
    RecyclerView recyclerView;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_replies);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        userid = new ArrayList<String>();
        username = new ArrayList<String>();
        reply = new ArrayList<String>();
        time = new ArrayList<String>();

        db = new Database(Replies.this);
        Cursor cursor = db.getAllReplies();
        if (cursor.moveToFirst()) {
            do {
                userid.add(cursor.getString(cursor.getColumnIndex(db.KEY_USER_ID)));
                username.add(cursor.getString(cursor.getColumnIndex(db.KEY_USER_NAME)));
                reply.add(cursor.getString(cursor.getColumnIndex(db.KEY_REPLY)));
                time.add(cursor.getString(cursor.getColumnIndex(db.KEY_USER_TIME)));
            } while (cursor.moveToNext());
        }
        ReplyAdapter replyadapter = new ReplyAdapter(Replies.this, userid, username, reply, time);
        recyclerView.setAdapter(replyadapter);
        Toast.makeText(this, "" + userid.size(), Toast.LENGTH_SHORT).show();
    }
}
