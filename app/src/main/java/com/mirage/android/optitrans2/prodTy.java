package com.mirage.android.optitrans2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class prodTy extends AppCompatActivity {
    Button back_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_prod_ty);
        getSupportActionBar().hide();
    }
    public void addListenerOnButton() {

        final Context context = this;

        back_btn = (Button) findViewById(R.id.button4);

        back_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, ura.class);
                startActivity(intent);

            }

        });

    }
}
