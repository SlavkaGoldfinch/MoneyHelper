package com.example.asus.moneyhelper12;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ListLoveMoney extends Activity implements View.OnClickListener {
    ArrayList<Item> plusMoney = new ArrayList<Item>();
    Adapter adapter;
    DBPlusMoney dbPlusMoney;
    Button bReturn;

    public void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list_plus_money);
        bReturn = (Button) findViewById(R.id.return_main);
        bReturn.setOnClickListener(this);

        dbPlusMoney = new DBPlusMoney(this);
        SQLiteDatabase database = dbPlusMoney.getWritableDatabase();
        String query = String.format("select * from %s", "DBLoveMoney");

        Cursor cursor = database.rawQuery(query, null);
        getAllPlusMoney(cursor);
        adapter = new Adapter(plusMoney, this);
        ListView listMain = (ListView) findViewById(R.id.listMain);
        listMain.setAdapter(adapter);


    }

    public void getAllPlusMoney(Cursor cursor) {

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                String[] values = cursor.getColumnNames();
                do {

                    plusMoney.add(new Item(
                            Integer.parseInt(cursor.getString(cursor.getColumnIndex(values[0]))),
                            Integer.parseInt(cursor.getString(cursor.getColumnIndex(values[1]))),
                            cursor.getString(cursor.getColumnIndex(values[2])),
                            cursor.getString(cursor.getColumnIndex(values[3]))));
                } while (cursor.moveToNext());

            }

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.return_main:
                Intent iMinus = new Intent(this, MainActivity.class);
                startActivity(iMinus);
                break;
        }
    }

}