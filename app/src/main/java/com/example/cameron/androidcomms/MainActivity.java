package com.example.cameron.androidcomms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private Button gBtn; //Gallery Button
    private Button sBtn; //Screenshot Button
    private Button exBtn; //Exit app Button

    // Used to load the 'native-lib' library on application startup.
    // static     {
    //            System.loadLibrary("native-lib"); //For C++ Support
//                }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button Definitions
        gBtn =  (Button)findViewById(R.id.ViewScrn); //Takes user to image gallery
        exBtn = (Button)findViewById(R.id.Exit_butt); //exit app
        sBtn =  (Button)findViewById(R.id.Scrn_butt); //Takes user to controls

        //Listener for button actions, allows button functionality
        exBtn.setOnClickListener(this);
        gBtn.setOnClickListener(this);
        sBtn.setOnClickListener(this);
    }

    //Button Functionality
    public void onClick (View view)
    {
        switch (view.getId())
        {
            case R.id.Exit_butt:
            {
                System.exit(0); //exit successfully
            }
            break;

            case R.id.ViewScrn:
            {
                GalleryIntent(); //Use pre-defined gallery method
            }
            break;

            case R.id.Scrn_butt:
            {
                Intent myIntent = new Intent(MainActivity.this, Scrn_Controls.class);
                MainActivity.this.startActivity(myIntent); //An intent to the next activity.
            }
            break;
        }

    }

    public void GalleryIntent() //Open the image gallery using a pre-installed android app on the users phone.
                                // Easier than creating our own library as Android has a default gallery app.
    {
        Intent intent =  new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivity(intent);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application. (C++ Lib)
     */
   // public native String stringFromJNI(); //Also C++ support
}
