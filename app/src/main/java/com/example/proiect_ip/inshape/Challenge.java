package com.example.proiect_ip.inshape;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View.OnClickListener;

public class Challenge extends AppCompatActivity {


    private Button button7;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final Context context = this;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.challenges);

        button =  (Button) findViewById(R.id.button);
        button7 = (Button) findViewById(R.id.button7);

        button7.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, Menu.class);

                startActivity(intent);
            }
        });

        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, NewChallenge.class);

                startActivity(intent);
            }
        });

    }
}
