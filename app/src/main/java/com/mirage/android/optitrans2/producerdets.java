package com.mirage.android.optitrans2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class producerdets extends AppCompatActivity {
    EditText prodName,prodID,prodMilk;
    Button prodLocn_btn;
    producerDatabase myDB;
    String pn,pi,pm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDB = new producerDatabase(this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_producerdets);
        getSupportActionBar().hide();
        prodName = (EditText) findViewById(R.id.editText4);
        prodID = (EditText) findViewById(R.id.editText5);
        prodMilk = (EditText) findViewById(R.id.editText6);

        pn = prodName.getText().toString();

        pi = prodID.getText().toString();
        pm = prodMilk.getText().toString();
        addListenerOnButton();

    }
    public void addListenerOnButton() {

        final Context context = this;

        prodLocn_btn = (Button) findViewById(R.id.button5);

        prodLocn_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, MapsActivity.class);
                intent.putExtra("prodName",pn);
                intent.putExtra("prodID",pi);
                intent.putExtra("prodMilk",pm);

                startActivity(intent);

            }

        });


    }


}
