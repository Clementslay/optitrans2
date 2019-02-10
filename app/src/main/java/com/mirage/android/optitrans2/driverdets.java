package com.mirage.android.optitrans2;

import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class driverdets extends AppCompatActivity {
    Button nearBy;
    EditText driverName,driverID,vehicleNo;
    RadioGroup vehicleType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_driverdets);
        getSupportActionBar().hide();
        driverName = (EditText) findViewById(R.id.editText);
        driverID = (EditText) findViewById(R.id.editText2);
        vehicleNo = (EditText) findViewById(R.id.editText3);

        addListenerOnButton();
    }
    public void addListenerOnButton() {
;
        final Context context = this;
        vehicleType = (RadioGroup)findViewById(R.id.radioGroup1);
        nearBy = (Button) findViewById(R.id.button8);


        nearBy.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, DriverList.class);
                startActivity(intent);

            }

        });
}}
