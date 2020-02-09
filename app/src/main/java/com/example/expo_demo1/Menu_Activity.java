package com.example.expo_demo1;

import android.content.DialogInterface;
import android.content.Intent;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

//Main Activity for Expo App
public class Menu_Activity extends AppCompatActivity {

    public static final String PREFS_NAME = "MyPrefsFile1";
    public CheckBox dontShowAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(Menu_Activity.this);
        boolean dialog_status = prefs
                .getBoolean("dialog_status", false);//get the status of the dialog from preferences, if false you ,ust show the dialog
        if (!dialog_status) {
            View content = getLayoutInflater().inflate(
                    R.layout.checkbox, null); // inflate the content of the dialog
            final CheckBox userCheck = (CheckBox) content //the checkbox from that view
                    .findViewById(R.id.check_box1);
            //build the dialog
            new AlertDialog.Builder(Menu_Activity.this)
                    .setTitle("Welcome!")
                    .setView(content)
                    .setPositiveButton("Ok",
                            new DialogInterface.OnClickListener() {

                                public void onClick(
                                        DialogInterface dialog,
                                        int which) {
                                    //find our if the user checked the checkbox and put true in the preferences so we don't show the dialog again
                                    SharedPreferences prefs = PreferenceManager
                                            .getDefaultSharedPreferences(Menu_Activity.this);
                                    SharedPreferences.Editor editor = prefs
                                            .edit();
                                    editor.putBoolean("dialog_status",
                                            userCheck.isChecked());
                                    editor.commit();
                                    Intent move_profile = new Intent(Menu_Activity.this,Profile_Activity.class);
                                    startActivity(move_profile);
                                    dialog.dismiss(); //end the dialog.
                                }
                            })
                    .setNegativeButton("Cancel",
                            new DialogInterface.OnClickListener() {

                                public void onClick(
                                        DialogInterface dialog,
                                        int which) {
                                    //find our if the user checked the checkbox and put true in the preferences so we don't show the dialog again
                                    SharedPreferences prefs = PreferenceManager
                                            .getDefaultSharedPreferences(Menu_Activity.this);
                                    SharedPreferences.Editor editor = prefs
                                            .edit();
                                    editor.putBoolean("dialog_status",
                                            userCheck.isChecked());
                                    editor.commit();
                                    dialog.dismiss();

                                }
                            }).show();
        }



        //How Button1 works
        Button Sub1_Button = (Button) findViewById(R.id.button1);
        Sub1_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Move to next Sub1Activity (Screen Transition)
                Intent move_main_sub1 = new Intent(Menu_Activity.this,Expo_Activity.class);
                startActivity(move_main_sub1);
            }
        });


        //How Maps Button works
        Button Sub2_Button = (Button) findViewById(R.id.button2);
        Sub2_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Move to next Sub1Activity (Screen Transition)
                Intent move_main_sub2 = new Intent(Menu_Activity.this,Map_Activity.class);
                startActivity(move_main_sub2);
            }
        });


        //How Button3 works
        Button Sub3_Button = (Button) findViewById(R.id.button3);
        Sub3_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Move to next Sub3Activity (Screen Transition)
                Intent move_main_sub3 = new Intent(Menu_Activity.this,Profile_Activity.class);
                startActivity(move_main_sub3);
            }
        });


        //How Button works
        Button Sub4_Button = (Button) findViewById(R.id.button4);
        Sub4_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Move to next Sub43Activity (Screen Transition)
                Intent move_main_sub4 = new Intent(Menu_Activity.this,Contact_Activity1.class);
                startActivity(move_main_sub4);
            }
        });

        ImageView iv_background = findViewById(R.id.iv_background);
        AnimationDrawable animationDrawable = (AnimationDrawable) iv_background.getDrawable();
        animationDrawable.start();
    }
}