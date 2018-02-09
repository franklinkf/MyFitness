package com.example.frank.myfitness;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by frank on 08-02-2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "FITNESS";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists fitness_data  (gdate date,gitem text,gvalue text,gvaluetype text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void saveData (String kdate, String kitem,String kvalue,String kvaluetype) throws ParseException {
        SQLiteDatabase db = this.getWritableDatabase();
        String sDate1="31/12/1998";
        Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(kdate);
        db.execSQL("insert into fitness_data values (" + date1 + ",'" + kitem + "','" + kvalue + "','" + kvaluetype + "')");
    }
}
