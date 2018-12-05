package com.example.asus.moneyhelper12;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBPlusMoney extends SQLiteOpenHelper {

    private Context context;

    final String LOG_TAG = "myLogs";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME ="DBPlusMoney";
    public static final String ID = "_id";

    public DBPlusMoney(Context context)
    {
        super(context,TABLE_NAME,null,DATABASE_VERSION);
        this.context=context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(LOG_TAG, "--- onCreate database ---");
        db.execSQL("create table DBPlusMoney ("
                + "id integer primary key autoincrement,"
                + "money text ,"
                + "data text,"
                + "comment text" + ");");

        db.execSQL("create table DBJobMoney ("
                + "id integer primary key autoincrement,"
                + "money text ,"
                + "data text,"
                + "comment text" + ");");

        db.execSQL("create table DBHomeMoney ("
                + "id integer primary key autoincrement,"
                + "money text ,"
                + "data text,"
                + "comment text" + ");");

        db.execSQL("create table DBLoveMoney ("
                + "id integer primary key autoincrement,"
                + "money text ,"
                + "data text,"
                + "comment text" + ");");

        db.execSQL("create table DBTransportMoney ("
                + "id integer primary key autoincrement,"
                + "money text ,"
                + "data text,"
                + "comment text" + ");");

        db.execSQL("create table DBFoodMoney ("
                + "id integer primary key autoincrement,"
                + "money text ,"
                + "data text,"
                + "comment text" + ");");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    @Override
    public void onOpen(SQLiteDatabase db) {
    }

}
