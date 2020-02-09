package com.example.expo_demo1;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.content.Context;
import android.view.LayoutInflater;
import android.app.AlertDialog;
import android.content.DialogInterface;
//For button1-1
public class Expo_Activity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expo_activity2);

        Button previous_Button = (Button) findViewById(R.id.previousSection);
        previous_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Move to next Sub1Activity (Screen Transition)
                Intent move_main1 = new Intent(Expo_Activity2.this, Expo_Activity.class);
                startActivity(move_main1);
            }
        });

        //How Button1 works
        Button Comp1_Button = (Button) findViewById(R.id.b13);
        Comp1_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context mContext = getApplicationContext();
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
                View layout = inflater.inflate(R.layout.info_13, (ViewGroup) findViewById(R.id.info13));
                AlertDialog.Builder aDialog = new AlertDialog.Builder(Expo_Activity2.this);

                aDialog.setView(layout);

                aDialog.setNegativeButton("close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                AlertDialog ad = aDialog.create();
                ad.show();
            }

        });


        Button Comp2_Button = (Button) findViewById(R.id.b14);
        Comp2_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context mContext = getApplicationContext();
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
                View layout = inflater.inflate(R.layout.info_14, (ViewGroup) findViewById(R.id.info14));
                AlertDialog.Builder aDialog = new AlertDialog.Builder(Expo_Activity2.this);

                aDialog.setView(layout);

                aDialog.setNegativeButton("close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                AlertDialog ad = aDialog.create();
                ad.show();
            }
        });


        Button Comp3_Button = (Button) findViewById(R.id.b15);
        Comp3_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context mContext = getApplicationContext();
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
                View layout = inflater.inflate(R.layout.info_15, (ViewGroup) findViewById(R.id.info15));
                AlertDialog.Builder aDialog = new AlertDialog.Builder(Expo_Activity2.this);

                aDialog.setView(layout);

                aDialog.setNegativeButton("close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                AlertDialog ad = aDialog.create();
                ad.show();
            }
        });


        Button Comp4_Button = (Button) findViewById(R.id.b16);
        Comp4_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context mContext = getApplicationContext();
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
                View layout = inflater.inflate(R.layout.info_16, (ViewGroup) findViewById(R.id.info16));
                AlertDialog.Builder aDialog = new AlertDialog.Builder(Expo_Activity2.this);

                aDialog.setView(layout);

                aDialog.setNegativeButton("close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                AlertDialog ad = aDialog.create();
                ad.show();
            }
        });

    }
}
