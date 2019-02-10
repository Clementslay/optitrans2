package com.mirage.android.optitrans2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class DriverList extends AppCompatActivity {
    Button driverMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_driver_list);
        getSupportActionBar().hide();
        addListenerOnButton();
    }


    public void addListenerOnButton() {

        final Context context = this;

        driverMap = (Button) findViewById(R.id.button9);


        driverMap.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, DriverMap.class);
                startActivity(intent);

            }

        });
}}
