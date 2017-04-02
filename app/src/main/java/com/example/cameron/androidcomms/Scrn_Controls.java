package com.example.cameron.androidcomms;


import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import android.view.View.OnClickListener;

import static android.R.attr.data;

/**
 * Created by Cameron on 04/02/2017.
 */

public class Scrn_Controls extends AppCompatActivity {

    //Varibles and stuff
    private Button scBtn; //Screenshot Request Button
    private Button prevBtn; //Previous Connections button, will open up a log
    private Button svBtn; //save button

    private EditText IPfield;
    private TextView response;

    public String fileIn;



    //For Receiving Image over the network
    ServerSocket serverSocket = null;
    Socket socket = null;
    DataInputStream dataInputStream = null;


    //Methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.controls);

        //Buttons
        scBtn = (Button) findViewById(R.id.scrnshot);
        prevBtn = (Button) findViewById(R.id.s_connections);
        svBtn = (Button) findViewById(R.id.Save);

        //Text Fields
        response = (TextView) findViewById(R.id.SaveDialog);
        IPfield = (EditText) findViewById(R.id.IPField);

        //Listeners // TODO: 07/03/2017


        //For Saving, On pressing the save button
        svBtn.setOnClickListener(new OnClickListener()

                //Button Control and Listeners
        {
            @Override
            public void onClick(View v)
            {
                switch (v.getId())
                {
                    case R.id.Save: //WORKS
                    {
                        fileIn = IPfield.getText().toString();
                        try
                        {
                            File file = new File(Environment.getExternalStorageDirectory(),"Admin_IPs.txt");

                            BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));

                            writer.write(fileIn);
                            writer.newLine();
                            writer.flush();
                            writer.close();
                        }
                        catch (IOException e) {

                            e.printStackTrace(); }
                    }
                    break;

                    case R.id.s_connections: //Retreive files from text file saved to phone
                    {


                    }


                        case R.id.scrnshot: //Get Screenshot from PC
                        {
                            try

                            {
                                serverSocket = new ServerSocket(6002);
                                System.out.println("Server is Waiting for request...");
                                socket = serverSocket.accept();
                                System.out.println("Connected with: " + socket.getInetAddress());
                                dataInputStream = new DataInputStream(socket.getInputStream());
                                System.out.println("Server Read from client: " + dataInputStream.readUTF());
                                //BufferedImage image = ImageIO.read(socket.getInputStream()); //ask ibrahim
                                System.out.println("Server: Image received from client.");


                            } catch (Exception e) {
                                e.printStackTrace();
                            }


                        }

                        break;
                }
                    } //End of OnClick Method
        });

    }



    //R/W Permission Check
    private static boolean isExternalStorageReadOnly() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    private static boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            return true;
        }
        return false;
    }




}


