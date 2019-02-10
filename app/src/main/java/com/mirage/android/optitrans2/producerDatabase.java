package com.mirage.android.optitrans2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class producerDatabase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "optitrans.db";
    public static final String TABLE_NAME = "producer_table";
    public static final String COL_1 = "PRODUCER_NAME";
    public static final String COL_2 = "PRODUCER_ID";
    public static final String COL_3 = "PRODUCER_AMT";
    public static final String COL_4 = "PRODUCER_LATI";
    public static final String COL_5 = "PRODUCER_LONGI";


    public producerDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (PRODUCER_NAME TEXT,PRODUCER_ID TEXT,PRODUCER_AMT TEXT,PRODUCER_LATI TEXT,PRODUCER_LONGI TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name,String id,String lit,String lat,String longi) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,name);
        contentValues.put(COL_2,id);
        contentValues.put(COL_3,lit);
        contentValues.put(COL_4,lat);
        contentValues.put(COL_5,longi);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

}

