package com.example.asus.moneyhelper12;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddPlusMoney extends Activity implements View.OnClickListener {

    private Button bNumberOne;
    private Button bNumberTwo;
    private Button bNumberThree;
    private Button bNumberFour;
    private Button bNumberFive;
    private Button bNumberSix;
    private Button bNumberSeven;
    private Button bNumberEight;
    private Button bNumberNine;

    private String money;
    private String data;
    private String comment;

    TextView tMoneyInfo;
    EditText etComment;
    private DBPlusMoney db;
    SQLiteDatabase database;
    ContentValues values = new ContentValues();

    final String LOG_TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plus_money);

        bNumberOne = (Button) findViewById(R.id.number_one1);
        bNumberOne.setOnClickListener(this);
        bNumberTwo = (Button) findViewById(R.id.number_two1);
        bNumberTwo.setOnClickListener(this);
        bNumberThree = (Button) findViewById(R.id.number_three1);
        bNumberThree.setOnClickListener(this);
        bNumberFour = (Button) findViewById(R.id.number_four1);
        bNumberFour.setOnClickListener(this);
        bNumberFive = (Button) findViewById(R.id.number_five1);
        bNumberFive.setOnClickListener(this);
        bNumberSix = (Button) findViewById(R.id.number_six1);
        bNumberSix.setOnClickListener(this);
        bNumberSeven = (Button) findViewById(R.id.number_seven1);
        bNumberSeven.setOnClickListener(this);
        bNumberEight = (Button) findViewById(R.id.number_eath1);
        bNumberEight.setOnClickListener(this);
        bNumberNine = (Button) findViewById(R.id.number_nine1);
        bNumberNine.setOnClickListener(this);
        Button bAdd = (Button) findViewById(R.id.plus_add);
        bAdd.setOnClickListener(this);

        tMoneyInfo = (TextView) findViewById(R.id.plus_money);
        etComment = (EditText) findViewById(R.id.plus_comment);

        db=new DBPlusMoney(this);
        database = db.getWritableDatabase();

    }

    public void onDestroy() {
        moveTaskToBack(true);
        super.onDestroy();
        System.runFinalizersOnExit(true);
        System.exit(0);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.number_one1:
                String bNumberOneText = bNumberOne.getText().toString();
                bNumberOneText = tMoneyInfo.getText().toString() + bNumberOneText;
                tMoneyInfo.setText(bNumberOneText);
                break;
            case R.id.number_two1:
                String bNumberTwoText = bNumberTwo.getText().toString();
                bNumberTwoText = tMoneyInfo.getText().toString() + bNumberTwoText;
                tMoneyInfo.setText(bNumberTwoText);
                break;
            case R.id.number_three1:
                String bNumberThreeText = bNumberThree.getText().toString();
                bNumberThreeText = tMoneyInfo.getText().toString() + bNumberThreeText;
                tMoneyInfo.setText(bNumberThreeText);
                break;
            case R.id.number_four1:
                String bNumberFourText = bNumberFour.getText().toString();
                bNumberFourText = tMoneyInfo.getText().toString() + bNumberFourText;
                tMoneyInfo.setText(bNumberFourText);
                break;
            case R.id.number_five1:
                String bNumberFiveText = bNumberFive.getText().toString();
                bNumberFiveText = tMoneyInfo.getText().toString() + bNumberFiveText;
                tMoneyInfo.setText(bNumberFiveText);
                break;
            case R.id.number_six1:
                String bNumberSixText = bNumberSix.getText().toString();
                bNumberSixText = tMoneyInfo.getText().toString() + bNumberSixText;
                tMoneyInfo.setText(bNumberSixText);
                break;
            case R.id.number_seven1:
                String bNumberSevenText = bNumberSeven.getText().toString();
                bNumberSevenText = tMoneyInfo.getText().toString() + bNumberSevenText;
                tMoneyInfo.setText(bNumberSevenText);
                break;
            case R.id.number_eath1:
                String bNumberEightText = bNumberEight.getText().toString();
                bNumberEightText = tMoneyInfo.getText().toString() + bNumberEightText;
                tMoneyInfo.setText(bNumberEightText);
                break;
            case R.id.number_nine1:
                String bNumberNineText = bNumberNine.getText().toString();
                bNumberNineText = tMoneyInfo.getText().toString() + bNumberNineText;
                tMoneyInfo.setText(bNumberNineText);
                break;
            case R.id.plus_add:

                values.put("money",tMoneyInfo.getText().toString());
                values.put("data","1.1.1999");
                values.put("comment",etComment.getText().toString());
                database.insert("DBPlusMoney", null, values);
                String query = String.format("select * from %s", "DBPlusMoney");
                Cursor cursor = database.rawQuery(query, null);
                getAllPlusMoney(cursor);

                Intent iReturn = new Intent(this, MainActivity.class);
                startActivity(iReturn);
                break;
        }
    }
    public void getAllPlusMoney(Cursor cursor) {

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                String[] values = cursor.getColumnNames();
                do {
                    Log.d(LOG_TAG,cursor.getString(cursor.getColumnIndex(values[0])) );
                    Log.d(LOG_TAG,cursor.getString(cursor.getColumnIndex(values[1])) );
                    Log.d(LOG_TAG,cursor.getString(cursor.getColumnIndex(values[2])) );
                    Log.d(LOG_TAG,cursor.getString(cursor.getColumnIndex(values[3])) );
                } while (cursor.moveToNext());

            }

        }
    }
}
