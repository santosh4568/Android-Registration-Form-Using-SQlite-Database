package com.example.registration_form_database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
public class myDatabase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "form_Info";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Details";
    private static final String KEY_ID = "Id";
    private static final String KEY_FIRST = "First_Name";
    private static final String KEY_LAST = "Last_Name";
    private static final String KEY_EMAIL = "Email";
    private static final String KEY_pass = "Password";
    private static final String KEY_PH = "Phone_Number";
    private static final String KEY_Add = "Address";
    private static final String KEY_gen = "Gender";
    private static final String KEY_st = "State";

    public myDatabase(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(" + KEY_ID + " INTEGER primary key AUTOINCREMENT," + KEY_FIRST + " TEXT," + KEY_LAST + " TEXT,"
                + KEY_EMAIL + " TEXT," + KEY_pass + " TEXT," + KEY_PH + " Text," + KEY_Add + " text," + KEY_gen + " text," + KEY_st + " text )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_NAME);
        onCreate(db);
    }

    public void addValues(String First_Name, String Last_Name, String Email, String Password, String Phone_Number, String Address,
                          String Gender, String State) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues val = new ContentValues();
        val.put(KEY_FIRST, First_Name);
        val.put(KEY_LAST,Last_Name);
        val.put(KEY_EMAIL,Email);
        val.put(KEY_pass,Password);
        val.put(KEY_PH,Phone_Number);
        val.put(KEY_Add,Address);
        val.put(KEY_gen,Gender);
        val.put(KEY_st,State);


        db.insert(TABLE_NAME,null,val);
    }


    public Cursor fetchdata()
    {
        SQLiteDatabase db =this.getReadableDatabase();
        String qry = "select * from "+TABLE_NAME;
        Cursor csr = db.rawQuery(qry,null);
        return csr;
    }
}