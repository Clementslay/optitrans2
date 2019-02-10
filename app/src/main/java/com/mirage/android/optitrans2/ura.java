package com.mirage.android.optitrans2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class ura extends AppCompatActivity {
    Button driv,prod;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_ura);
        getSupportActionBar().hide();
        addListenerOnButton();
    }
    public void addListenerOnButton() {

        final Context context = this;

        driv = (Button) findViewById(R.id.button6);
        prod = (Button) findViewById(R.id.button7);

       driv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, driverdets.class);
                startActivity(intent);

            }

        });
        prod.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, producerdets.class);
                startActivity(intent);

            }

        });
    }
}
