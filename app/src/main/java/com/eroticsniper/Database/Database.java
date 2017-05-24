package com.eroticsniper.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by bhushan on 16-02-2017.
 */

public class Database extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "Erotic.db";
    // Contacts table name
    private static final String TABLE_NOTIFICATIONS = "NotificationTable";
    public static final String KEY_SNo = "s_no";
    public static final String KEY_USER_ID = "user_id";
    public static final String KEY_USER_NAME = "user_name";
    public static final String KEY_REPLY = "user_reply";
    public static final String KEY_USER_TIME = "reply_time";

    public Database(Context context) {
        //Environment.getExternalStorageDirectory() + File.separator + "PointOfSale" + File.separator +
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_NOTIFICATIONS + "(" + KEY_SNo + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," + KEY_USER_ID + " INTEGER," + KEY_USER_NAME + " TEXT," + KEY_REPLY + " TEXT," + KEY_USER_TIME + " TEXT " + "  )";
        db.execSQL(CREATE_CONTACTS_TABLE);

        Log.e("Create_Table", "" + CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        if (newVersion > oldVersion) {
        }// Create tables again
        onCreate(db);

    }


    //==============ajay====================//
    public void reset_table() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NOTIFICATIONS, null, null);
        db.execSQL("delete from " + TABLE_NOTIFICATIONS);
    }

    public long addItems(String user_id, String user_name, String user_reply, String reply_time) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_USER_ID, user_id);
        values.put(KEY_USER_NAME, user_name);
        values.put(KEY_REPLY, user_reply);
        values.put(KEY_USER_TIME, reply_time);
        long rowInserted = db.insert(TABLE_NOTIFICATIONS, null, values);
        return rowInserted;
    }

    //
//
//    //    =======================add items to cart================//
//    public long addFirstTimeCartItem(int Cat_id, int variantid, String variantName, int variantquantity, String variantPrice) {
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(C_ID, Cat_id);
//        values.put(KEY_VARIANT_ID, variantid);
//        values.put(KEY_VARIANT_NAME, variantName);
//        values.put(KEY_VARIANT_PRICE, variantPrice);
//        values.put(KEY_QUANTITY, variantquantity);
//
//        long rowInserted = db.insert(VARIANT_TABLE, null, values);
//
//        return rowInserted;
//    }
//
//
//    // ====================Getting contacts Count========================//
    public int getItemsCount() {
        int count = 0;
        String countQuery = "SELECT  * FROM " + TABLE_NOTIFICATIONS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        if (cursor != null && !cursor.isClosed()) {
            count = cursor.getCount();
        }
        return count;
    }

    public Cursor getAllReplies() {
        String countQuery = "SELECT  * FROM " + TABLE_NOTIFICATIONS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        return cursor;
    }

//
//    public int getVariantCount(int id) {
//        int count = 0;
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor c = db.rawQuery("SELECT * FROM " + VARIANT_TABLE + " where " + C_ID + " = '" + id + "'", null);
//        count = c.getCount();
//        return count;
//    }
//
//
//    //============only for  without varients items(direct Products)===========//
//    //=============Check Product is already available or not===============//
//    public int CheckProductAvailablity(int id) {
//        int count = 0;
//
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_CART_ITEMS + " where " + KEY_PRODUCT_ID + " = '" + id + "'", null);
//        count = c.getCount();
//        return count;
//    }
//
//    //============only for  without varients items(direct Products)===========//
//    //=============get quantity of product===============//
//    public Cursor getProductquantity(String id) {
//
//        Cursor c = null;
//        SQLiteDatabase db = this.getReadableDatabase();
//        c = db.rawQuery("SELECT " + KEY_PRODUCT_QUANTTY + " FROM " + TABLE_CART_ITEMS + " where " + KEY_PRODUCT_ID + " = '" + id + "'", null);
//        return c;
//    }
//
//    //=============get quantity of product===============//
//    public Cursor getProductRowId(int id) {
//
//        Cursor c = null;
//        SQLiteDatabase db = this.getReadableDatabase();
//        c = db.rawQuery("SELECT " + C_ID + " FROM " + TABLE_CART_ITEMS + " where " + KEY_PRODUCT_ID + " = '" + id + "'", null);
//        return c;
//    }
//
//    //=============select all data from Product table for cart==========//
//    //=============get quantity of product===============//
//    public Cursor getProductForCart() {
//
//        Cursor c = null;
//        SQLiteDatabase db = this.getReadableDatabase();
//        c = db.rawQuery("SELECT * FROM " + TABLE_CART_ITEMS, null);
//        return c;
//    }
//
//
//    //=============get quantity of product===============//
//    public Cursor getVariantIdByC_ID(int id) {
//
//        Cursor c = null;
//        SQLiteDatabase db = this.getReadableDatabase();
//        c = db.rawQuery("SELECT * FROM " + VARIANT_TABLE + " where " + C_ID + " = '" + id + "'", null);
//        return c;
//    }
//
//    //==================update quantity===================//
//    public void updateProductquantity(String id, int quantity) {
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues cv = new ContentValues();
//        cv.put(KEY_PRODUCT_QUANTTY, quantity); //These Fields should be your String values of actual column names
//
//        db.update(TABLE_CART_ITEMS, cv, KEY_PRODUCT_ID + "=" + id, null);
//
//
//    }
//
//    //==================update quantity===================//
//    public void updateProductquantitybyC_ID(String id, int quantity) {
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues cv = new ContentValues();
//        cv.put(KEY_PRODUCT_QUANTTY, quantity); //These Fields should be your String values of actual column names
//
//        db.update(TABLE_CART_ITEMS, cv, C_ID + "=" + id, null);
//
//
//    }
//
//
//    //==============delete items from cart=============//
//    public void delete(String p) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.execSQL("DELETE FROM " + TABLE_CART_ITEMS + " WHERE " + C_ID + " = " + p + "");
//        db.execSQL("DELETE FROM " + VARIANT_TABLE + " WHERE " + C_ID + " = " + p + "");
//
//    }
//
//    //=============get quantity of product===============//
//    public Cursor getProductquantityByC_id(String id) {
//
//        Cursor c = null;
//        SQLiteDatabase db = this.getReadableDatabase();
//        c = db.rawQuery("SELECT " + KEY_PRODUCT_QUANTTY + " FROM " + TABLE_CART_ITEMS + " where " + C_ID + " = '" + id + "'", null);
//        return c;
//    }
}
