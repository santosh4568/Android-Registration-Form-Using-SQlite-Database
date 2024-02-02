package com.example.registration_form_database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity
{
    TextView t1,t2,t3,t4,t5,t6,t7,t8;
    Button b;
    myDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t1 = (TextView) findViewById(R.id.textView3);
        t2 = (TextView) findViewById(R.id.textView4);
        t3 = (TextView) findViewById(R.id.textView5);
        t4 = (TextView) findViewById(R.id.textView6);
        t5 = (TextView) findViewById(R.id.textView7);
        t6 = (TextView) findViewById(R.id.textView8);
        t7 = (TextView) findViewById(R.id.textView9);
        t8 = (TextView) findViewById(R.id.textView10);
        b = (Button) findViewById(R.id.button3);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fetchdata();
            }

            private void fetchdata() {
                db = new myDatabase(MainActivity2.this);
                Cursor res = db.fetchdata();
                while(res.moveToNext())
                {
                    t1.setText("First Name :"+res.getString(1));
                    t2.setText("Last Name : "+res.getString(2));
                    t3.setText("Email :"+res.getString(3));
                    t4.setText("Password :"+res.getString(4));
                    t5.setText("Mobile Number :"+res.getString(5));
                    t6.setText("Address :"+res.getString(6));
                    t7.setText("Gender :"+res.getString(7));
                    t8.setText("State :"+res.getString(8));
                }
            }
        });
    }
}