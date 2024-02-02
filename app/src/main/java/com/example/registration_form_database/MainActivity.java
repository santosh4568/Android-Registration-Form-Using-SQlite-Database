package com.example.registration_form_database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    EditText t1,t2,t3,t4,t5,t6;
    RadioButton rb1,rb2;
    Spinner sp;
    Button b,b1;
    String [] state = {"Select state","Andhra Pradesh","Arunachal Pradesh ","Assam","Bihar","Chhattisgarh","Goa","Gujarat","Haryana","Himachal Pradesh","Jammu and Kashmir","Jharkhand","Karnataka","Kerala","Madhya Pradesh","Maharashtra",
            "Manipur","Meghalaya","Mizoram","Nagaland","Odisha","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttar Pradesh","Uttarakhand","West Bengal"};
    String fname,lname,email,pass,ph,address,gen="",st,temp1,temp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = (EditText) findViewById(R.id.editTextText);
        t2 = (EditText) findViewById(R.id.editTextText2);
        t3 = (EditText) findViewById(R.id.editTextTextEmailAddress);
        t4 = (EditText) findViewById(R.id.editTextNumberPassword);
        t5 = (EditText) findViewById(R.id.editTextPhone);
        t6 = (EditText) findViewById(R.id.editTextTextPostalAddress);
        rb1 = (RadioButton) findViewById(R.id.radioButton);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        sp = (Spinner) findViewById(R.id.spinner);
        b = (Button) findViewById(R.id.button);
        b1 = (Button) findViewById(R.id.button2);
        ArrayAdapter<String> ad = new ArrayAdapter<String>(MainActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,state);
        sp.setAdapter(ad);
        myDatabase md = new myDatabase(MainActivity.this);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fname= t1.getText().toString();
                lname = t2.getText().toString();
                email = t3.getText().toString();
                pass =  t4.getText().toString();
                ph = t5.getText().toString();
                address = t6.getText().toString();
                md.addValues(fname,lname,email,pass,ph,address,gen,st);
            }
        });
        rb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true)
                {
                    rb2.setChecked(false);
                    temp1 = rb1.getText().toString();
                    gen=temp1;
                }
                else
                {
                    gen=gen.replace(temp1,"");
                }
            }
        });
        rb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true)
                {
                    rb1.setChecked(false);
                    temp2 = rb2.getText().toString();
                    gen=temp2;
                }
                else
                {
                    gen=gen.replace(temp2,"");
                }
            }
        });
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String rj = parent.getItemAtPosition(position).toString();
                st=rj;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(i);
            }
        });
    }
}