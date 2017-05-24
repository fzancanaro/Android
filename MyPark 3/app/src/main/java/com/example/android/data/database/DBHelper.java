package com.example.android.data.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.data.model.DataItem;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_FILE_NAME = "mydb1.db";
    public static final int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_FILE_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ItemsTable.SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(ItemsTable.SQL_DELETE);
        onCreate(db);
    }
/*
    public ArrayList<DataItem> getItemsByActivity(String activity, SQLiteDatabase db){
        ArrayList<DataItem> list = new ArrayList<DataItem>();

        String selectString = "select * from items where category= '"+activity+"'";

        Cursor cursor = db.query(selectString);
    }*/
}
