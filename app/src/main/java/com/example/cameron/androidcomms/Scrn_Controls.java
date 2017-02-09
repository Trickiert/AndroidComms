package com.example.cameron.androidcomms;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Cameron on 04/02/2017.
 */

public class Scrn_Controls extends AppCompatActivity
{
    private Button scBtn; //ScreenshotButton
    private Button lBtn; //Previous Connections button, will open up a log
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.controls);

        scBtn = (Button)findViewById(R.id.scrnshot);
        lBtn = (Button)findViewById(R.id.s_connections);

    }

    public void onClick (View view)
    {
         switch (view.getId()) {
             case R.id.scrnshot:
             {
                 //intent to server
             }
             break;

             case R.id.s_connections:
             {
                 //intent to previous ip connections
             }
             break;

        }
    }



}
