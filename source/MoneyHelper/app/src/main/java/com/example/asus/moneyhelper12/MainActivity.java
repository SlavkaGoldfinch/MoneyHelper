package com.example.asus.moneyhelper12;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    Button bMinus;
    Button mPlus;
    Button bFood;
    Button bHome;
    Button bTransport;
    Button bLove;
    Button bJob;
    Button bPlusMoney;
    TextView twInfMoney;

   String[] stringsDB= new String[]{"DBPlusMoney", "DBFoodMoney", "DBHomeMoney", "DBJobMoney", "DBLoveMoney", "DBTransportMoney"};
    final int endOfString=6;

    SQLiteDatabase database;
    private DBPlusMoney db;
    Cursor cursor;

    MainActivity mainActivity;

    static String theme= "white";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bMinus = (Button) findViewById(R.id.add_minus_button);
        bMinus.setOnClickListener(this);
        mPlus = (Button) findViewById(R.id.add_plus_button);
        mPlus.setOnClickListener(this);
        bPlusMoney = (Button) findViewById(R.id.plus_money);
        bPlusMoney.setOnClickListener(this);
        bFood = (Button) findViewById(R.id.food);
        bFood.setOnClickListener(this);
        bJob = (Button) findViewById(R.id.job);
        bJob.setOnClickListener(this);
        bTransport = (Button) findViewById(R.id.transport);
        bTransport.setOnClickListener(this);
        bLove = (Button) findViewById(R.id.love);
        bLove.setOnClickListener(this);
        bHome = (Button) findViewById(R.id.home);
        bHome.setOnClickListener(this);

        db = new DBPlusMoney(this);
        database = db.getWritableDatabase();

        twInfMoney = (TextView) findViewById(R.id.information_money);
        twInfMoney.setText(SumAllMoney(cursor));
    }

    public void onDestroy() {
        moveTaskToBack(true);

        super.onDestroy();

        System.runFinalizersOnExit(true);
        System.exit(0);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_minus_button:
                Intent iMinus = new Intent(this, AddMinusMoney.class);
                startActivity(iMinus);
                break;
            case R.id.add_plus_button:
                Intent iPlus = new Intent(this, AddPlusMoney.class);
                startActivity(iPlus);
                break;
            case R.id.plus_money:
                Intent iPlusMoney = new Intent(this, ListPlusMoney.class);
                startActivity(iPlusMoney);
                break;
            case R.id.love:
                Intent iLove = new Intent(MainActivity.this, ListLoveMoney.class);
                startActivity(iLove);
                break;
            case R.id.transport:
                Intent iTransport = new Intent(MainActivity.this, ListTransportMoney.class);
                startActivity(iTransport);

                break;
            case R.id.home:
                Intent iHome = new Intent(MainActivity.this, ListHomeMoney.class);
                startActivity(iHome);
                break;
            case R.id.food:
                Intent iFood = new Intent(MainActivity.this, ListFoodMoney.class);
                startActivity(iFood);
                break;
            case R.id.job:
                Intent iJob = new Intent(MainActivity.this, ListJobMoney.class);
                startActivity(iJob);
                break;
        }
    }

    @SuppressLint("Recycle")
    public String SumAllMoney(Cursor cursor) {

        int moneyPlus = 0;
        int moneyMinus = 0;
        String string;

        String query = String.format("select * from %s", stringsDB[0]);
        cursor = database.rawQuery(query, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                String[] values = cursor.getColumnNames();
                do {
                    moneyPlus += Integer.parseInt(cursor.getString(cursor.getColumnIndex(values[1])));
                } while (cursor.moveToNext());
            }
        }
        cursor.close();
        for (int iterator = 1; iterator < endOfString; iterator++) {
            query = String.format("select * from %s", stringsDB[iterator]);
            cursor = database.rawQuery(query, null);
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    String[] values = cursor.getColumnNames();
                    do {
                        moneyMinus += Integer.parseInt(cursor.getString(cursor.getColumnIndex(values[1])));
                    } while (cursor.moveToNext());
                }
            }
            cursor.close();
        }
        string=String.format("account = %s rub ", moneyPlus-moneyMinus);
        return string;
    }
}
