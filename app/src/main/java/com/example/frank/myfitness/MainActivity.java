package com.example.frank.myfitness;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.database.sqlite.SQLiteDatabase;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    DatabaseHelper myDb;

    ImageButton imgBack;
    ImageButton imgForward;

    TextView tvDate;
    TextView tvWakeUp;
    TextView tvWeight;
    TextView tvBreadth;
    TextView tvWalking;
    TextView tvCycling;
    TextView tvYoga;
    TextView tvMeat;
    TextView tvFish;
    TextView tvBakery;
    TextView tvFruits;

    EditText etWakeUp;
    EditText etWeight;
    EditText etBreadth;
    EditText etWalking;
    EditText etCycling;

    Spinner spWeight;
    Spinner spBreadth;
    Spinner spWalking;
    Spinner spCycling;
    Spinner spYoga;
    Spinner spMeat;
    Spinner spFish;
    Spinner spBakery;
    Spinner spFruits;

    Button btnSave;


    String[] WalkingMeterType={"Kilometer","Mile","Minute"};
    String[] cyclingMeterType={"Kilometer","Mile","Minute"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        tvDate = (TextView)findViewById(R.id.tvDate);
        tvWakeUp = (TextView)findViewById(R.id.tvWakeUp);
        tvWeight = (TextView)findViewById(R.id.tvWeight);
        tvBreadth = (TextView)findViewById(R.id.tvBreadth);
        tvWalking = (TextView)findViewById(R.id.tvWalking);
        tvCycling = (TextView)findViewById(R.id.tvCycling);
        tvYoga = (TextView)findViewById(R.id.tvYoga);
        tvMeat = (TextView)findViewById(R.id.tvMeat);

        etWakeUp = (EditText) findViewById(R.id.etWakeUp);
        etWeight = (EditText) findViewById(R.id.etWeight);
        etBreadth = (EditText) findViewById(R.id.etBreadth);
        etWalking = (EditText) findViewById(R.id.etWalking);
        etCycling = (EditText) findViewById(R.id.etCycling);

        spWeight = (Spinner) findViewById(R.id.spWeight);
        spBreadth = (Spinner) findViewById(R.id.spBreadth);
        spWalking = (Spinner) findViewById(R.id.spWalking);
        spCycling = (Spinner) findViewById(R.id.spCycling);
        spYoga = (Spinner) findViewById(R.id.spYoga);
        spMeat = (Spinner) findViewById(R.id.spMeat);

        btnSave = (Button) findViewById(R.id.btnsave);

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        tvDate.setText(dateFormat.format(date));

/*
        Spinner spWalking = (Spinner) findViewById(R.id.spWalking);
        spWalking.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the bank name list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,WalkingMeterType);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spWalking.setAdapter(aa);
*/

/*        Switch simpleSwitch = (Switch) findViewById(R.id.simpleSwitch); // initiate Switch

        simpleSwitch.setTextOn("On"); // displayed text of the Switch whenever it is in checked or on state
        simpleSwitch.setTextOff("Off");*/

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void saveData(View view){
        Log.i("Info","Button Pressed");

        try {
            SQLiteDatabase eventsDB = this.openOrCreateDatabase("fitness", MODE_PRIVATE, null);
            eventsDB.execSQL("create table if not exists fitness_data  (gdate date,gitem text,gvalue text,gvaluetype text)");
            eventsDB.execSQL("delete from fitness_data");

            String strAsOn = tvDate.getText().toString();
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            Date dtAsOn = format.parse(strAsOn);
            String stritem = tv



            eventsDB.execSQL("insert into fitness_data values ('2018-02-10','Walking','2','KM')");
            eventsDB.execSQL("insert into fitness_data values ('2018-02-10','Walking','3','KM')");
            eventsDB.execSQL("insert into fitness_data values ('2018-02-10','Walking','4','KM')");
            Cursor c = eventsDB.rawQuery("select gdate,gitem,gvalue,gvaluetype from fitness_data", null);
            int kitem = c.getColumnIndex("gitem");
            int kvalue = c.getColumnIndex("gvalue");
            int kvaluetype = c.getColumnIndex("gvaluetype");
            c.moveToFirst();
            while (!c.isAfterLast()) {

                Log.i("AAAAAItem", c.getString(kitem));
                Log.i("AAAAAValue", c.getString(kvalue));
                Log.i("AAAAAValue Type", c.getString(kvaluetype));

                c.moveToNext();
            }

        } catch (Exception e){
            Log.i("Itemaaa", e.getMessage().toString());
        }





    }
}
