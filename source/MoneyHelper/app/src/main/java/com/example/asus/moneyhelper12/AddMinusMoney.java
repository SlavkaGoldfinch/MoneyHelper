package com.example.asus.moneyhelper12;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class AddMinusMoney extends Activity implements View.OnClickListener {

    private Button bNumberOne;
    private Button bNumberTwo;
    private Button bNumberThree;
    private Button bNumberFour;
    private Button bNumberFive;
    private Button bNumberSix;
    private Button bNumberSeven;
    private Button bNumberEight;
    private Button bNumberNine;

    int databaseType;

    TextView tMoneyInfo;
    EditText etComment;
    private DBPlusMoney db;
    SQLiteDatabase database;
    ContentValues values = new ContentValues();

    final String LOG_TAG = "myLogs";

    String[] dataSpiner = {
            "HOME",
            "LOVE",
            "TRANSPORT",
            "JOB",
            "FOOD"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_minus_money);

        bNumberOne = (Button) findViewById(R.id.number_one2);
        bNumberOne.setOnClickListener(this);
        bNumberTwo = (Button) findViewById(R.id.number_two2);
        bNumberTwo.setOnClickListener(this);
        bNumberThree = (Button) findViewById(R.id.number_three2);
        bNumberThree.setOnClickListener(this);
        bNumberFour = (Button) findViewById(R.id.number_four2);
        bNumberFour.setOnClickListener(this);
        bNumberFive = (Button) findViewById(R.id.number_five2);
        bNumberFive.setOnClickListener(this);
        bNumberSix = (Button) findViewById(R.id.number_six2);
        bNumberSix.setOnClickListener(this);
        bNumberSeven = (Button) findViewById(R.id.number_seven2);
        bNumberSeven.setOnClickListener(this);
        bNumberEight = (Button) findViewById(R.id.number_eath2);
        bNumberEight.setOnClickListener(this);
        bNumberNine = (Button) findViewById(R.id.number_nine2);
        bNumberNine.setOnClickListener(this);
        Button bAdd = (Button) findViewById(R.id.minus_add);
        bAdd.setOnClickListener(this);

        tMoneyInfo = (TextView) findViewById(R.id.minus_money);
        etComment = (EditText) findViewById(R.id.minus_comment);

        db=new DBPlusMoney(this);
        database = db.getWritableDatabase();

        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataSpiner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final Spinner spinner = findViewById(R.id.spinner_add);
        spinner.setAdapter(adapter);
        spinner.setPrompt("Choose Category");
        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            /**
             *
             *
             */
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                switch (position) {
                    case 0: databaseType=1;
                        Toast.makeText(getBaseContext(), "You choose HOME category", Toast.LENGTH_SHORT).show();break;
                    case 1: databaseType=2;
                        Toast.makeText(getBaseContext(), "You choose LOVE category", Toast.LENGTH_SHORT).show();break;
                    case 2: databaseType=3;
                        Toast.makeText(getBaseContext(), "You choose TRANSPORT category", Toast.LENGTH_SHORT).show();break;
                    case 3: databaseType=4;
                        Toast.makeText(getBaseContext(), "You choose JOB category", Toast.LENGTH_SHORT).show();break;
                    case 4: databaseType=5;
                        Toast.makeText(getBaseContext(), "You choose FOOD category", Toast.LENGTH_SHORT).show();break;
            }
        }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void onDestroy() {
        moveTaskToBack(true);
        super.onDestroy();
        System.runFinalizersOnExit(true);
        System.exit(0);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.number_one2:
                String bNumberOneText = bNumberOne.getText().toString();
                bNumberOneText = tMoneyInfo.getText().toString() + bNumberOneText;
                tMoneyInfo.setText(bNumberOneText);
                break;
            case R.id.number_two2:
                String bNumberTwoText = bNumberTwo.getText().toString();
                bNumberTwoText = tMoneyInfo.getText().toString() + bNumberTwoText;
                tMoneyInfo.setText(bNumberTwoText);
                break;
            case R.id.number_three2:
                String bNumberThreeText = bNumberThree.getText().toString();
                bNumberThreeText = tMoneyInfo.getText().toString() + bNumberThreeText;
                tMoneyInfo.setText(bNumberThreeText);
                break;
            case R.id.number_four2:
                String bNumberFourText = bNumberFour.getText().toString();
                bNumberFourText = tMoneyInfo.getText().toString() + bNumberFourText;
                tMoneyInfo.setText(bNumberFourText);
                break;
            case R.id.number_five2:
                String bNumberFiveText = bNumberFive.getText().toString();
                bNumberFiveText = tMoneyInfo.getText().toString() + bNumberFiveText;
                tMoneyInfo.setText(bNumberFiveText);
                break;
            case R.id.number_six2:
                String bNumberSixText = bNumberSix.getText().toString();
                bNumberSixText = tMoneyInfo.getText().toString() + bNumberSixText;
                tMoneyInfo.setText(bNumberSixText);
                break;
            case R.id.number_seven2:
                String bNumberSevenText = bNumberSeven.getText().toString();
                bNumberSevenText = tMoneyInfo.getText().toString() + bNumberSevenText;
                tMoneyInfo.setText(bNumberSevenText);
                break;
            case R.id.number_eath2:
                String bNumberEightText = bNumberEight.getText().toString();
                bNumberEightText = tMoneyInfo.getText().toString() + bNumberEightText;
                tMoneyInfo.setText(bNumberEightText);
                break;
            case R.id.number_nine2:
                String bNumberNineText = bNumberNine.getText().toString();
                bNumberNineText = tMoneyInfo.getText().toString() + bNumberNineText;
                tMoneyInfo.setText(bNumberNineText);
                break;
            case R.id.minus_add:
                AddToSQlTable(databaseType);
                Intent iReturn = new Intent(this, MainActivity.class);
                startActivity(iReturn);
                break;
        }
    }
    public void getAllMinusMoney(Cursor cursor) {

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
    public void AddToSQlTable(int category)
    {
        values.put("money",tMoneyInfo.getText().toString());
        values.put("data","1.1.1999");
        values.put("comment",etComment.getText().toString());
        switch (category)
        {
            case 1: database.insert("DBHomeMoney", null, values);break;
            case 2: database.insert("DBLoveMoney", null, values);break;
            case 3: database.insert("DBTransportMoney", null, values);break;
            case 4: database.insert("DBJobMoney", null, values);break;
            case 5: database.insert("DBFoodMoney", null, values);break;
        }
    }
}