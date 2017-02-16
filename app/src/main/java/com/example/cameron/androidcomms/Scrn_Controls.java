package com.example.cameron.androidcomms;


import android.content.Context;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import static android.R.attr.data;


/**
 * Created by Cameron on 04/02/2017.
 */

public class Scrn_Controls extends AppCompatActivity {
    private Button scBtn; //Screenshot Request Button
    private Button lBtn; //Previous Connections button, will open up a log
    private Button svBtn; //save button

    private static final String TAG = Scrn_Controls.class.getName();
    private static final String FILENAME = "ips.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.controls);

        //Buttons
        scBtn = (Button) findViewById(R.id.scrnshot);
        lBtn = (Button) findViewById(R.id.s_connections);
        svBtn = (Button) findViewById(R.id.Save);

        //Listeners


    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.scrnshot: {
                //intent to server
            }
            break;

            case R.id.Save:
            {
                //Save_To_File();

            }
            break;

        }
    }

    public void Save_To_File(String data) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput(FILENAME, Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        } catch (IOException e) {
            Log.e(TAG, "File write failed: " + e.toString()); //Error Handling
        }

    }

    public String Read_File() {
        String ret = "";

        try {
            InputStream inputStream = openFileInput(FILENAME);

            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ((receiveString = bufferedReader.readLine()) != null) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        } catch (FileNotFoundException e) {
            Log.e(TAG, "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e(TAG, "Can not read file: " + e.toString());
        }
        return ret;
    }

}


