package com.eroticsniper.Database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by bhushan on 16-02-2017.
 */

public class SqliteController {

    private Database dbHelper;
    private Context ourcontext;
    private SQLiteDatabase database;


    public SqliteController(Context c) {
        ourcontext = c;
    }

    public SqliteController open() throws SQLException {

        dbHelper = new Database(ourcontext);
        database = dbHelper.getWritableDatabase();
        database = dbHelper.getReadableDatabase();

        return this;

    }

    public void close() {
        dbHelper.close();
    }

    private SQLiteDatabase getWritableDatabase() {
        // TODO Auto-generated method stub
        return null;


    }
}
