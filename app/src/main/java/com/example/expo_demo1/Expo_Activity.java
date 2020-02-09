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
import android.widget.ImageButton;
import android.widget.TextView;


//For Button1
public class Expo_Activity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expo_activity);
        //color change
        TextView colorb1 = (TextView)findViewById(R.id.b1);
        TextView colorb2 = (TextView)findViewById(R.id.b2);
        TextView colorb3= (TextView)findViewById(R.id.b3);
        TextView colorb4 = (TextView)findViewById(R.id.b4);
        TextView colorb5 = (TextView)findViewById(R.id.b5);
        TextView colorb6 = (TextView)findViewById(R.id.b6);
        TextView colorb7 = (TextView)findViewById(R.id.b8);
        TextView colorb8 = (TextView)findViewById(R.id.b7);
        TextView colorb9 = (TextView)findViewById(R.id.b9);
        TextView colorb10 = (TextView)findViewById(R.id.b10);
        TextView colorb11 = (TextView)findViewById(R.id.b11);
        TextView colorb12= (TextView)findViewById(R.id.b12);

        //radomly choose numeric value
        double gpa = 3.3;
        int gradDate = 3;
        int major = 5;

        //color change
        if (gpa > 3 && gradDate > 1 && (major == 5 | major == 4)) {

            colorb1.setTextColor(getResources().getColor(R.color.greenLight));
        }

        if (gpa > 3.6 && gradDate > 1 && (major == 5 | major == 4)) {

            colorb2.setTextColor(getResources().getColor(R.color.greenLight));
        }
        Button next_Button = (Button) findViewById(R.id.nextSection);
        next_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Move to next expo activity2 (Screen Transition)
                Intent move_main2 = new Intent(Expo_Activity.this,Expo_Activity2.class);
                startActivity(move_main2);
            }
        });

        //go to home
        ImageButton home_Button = (ImageButton) findViewById(R.id.Home);
        home_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Move to next meun activity (Screen Transition)
                Intent move_main3 = new Intent(Expo_Activity.this,Menu_Activity.class);
                startActivity(move_main3);
            }
        });

        //How Button1 works
        Button Comp1_Button = (Button) findViewById(R.id.b1);
        Comp1_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context mContext = getApplicationContext();
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
                View layout = inflater.inflate(R.layout.info_1,(ViewGroup) findViewById(R.id.info1));
                AlertDialog.Builder aDialog = new AlertDialog.Builder(Expo_Activity.this);

                aDialog.setView(layout);

                aDialog.setNegativeButton("close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                AlertDialog ad = aDialog.create();
                ad.show();}

        });


        Button Comp2_Button = (Button) findViewById(R.id.b2);
        Comp2_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context mContext = getApplicationContext();
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
                View layout = inflater.inflate(R.layout.info_2,(ViewGroup) findViewById(R.id.info2));
                AlertDialog.Builder aDialog = new AlertDialog.Builder(Expo_Activity.this);

                aDialog.setView(layout);

                aDialog.setNegativeButton("close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                AlertDialog ad = aDialog.create();
                ad.show();}
        });


        Button Comp3_Button = (Button) findViewById(R.id.b3);
        Comp3_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context mContext = getApplicationContext();
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
                View layout = inflater.inflate(R.layout.info_3,(ViewGroup) findViewById(R.id.info3));
                AlertDialog.Builder aDialog = new AlertDialog.Builder(Expo_Activity.this);

                aDialog.setView(layout);

                aDialog.setNegativeButton("close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                AlertDialog ad = aDialog.create();
                ad.show();}
        });


        Button Comp4_Button = (Button) findViewById(R.id.b4);
        Comp4_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context mContext = getApplicationContext();
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
                View layout = inflater.inflate(R.layout.info_4,(ViewGroup) findViewById(R.id.info4));
                AlertDialog.Builder aDialog = new AlertDialog.Builder(Expo_Activity.this);

                aDialog.setView(layout);

                aDialog.setNegativeButton("close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                AlertDialog ad = aDialog.create();
                ad.show();}
        });


        Button Comp5_Button = (Button) findViewById(R.id.b5);
        Comp5_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context mContext = getApplicationContext();
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
                View layout = inflater.inflate(R.layout.info_5,(ViewGroup) findViewById(R.id.info5));
                AlertDialog.Builder aDialog = new AlertDialog.Builder(Expo_Activity.this);

                aDialog.setView(layout);

                aDialog.setNegativeButton("close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                AlertDialog ad = aDialog.create();
                ad.show();}
        });


        Button Comp6_Button = (Button) findViewById(R.id.b6);
        Comp6_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context mContext = getApplicationContext();
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
                View layout = inflater.inflate(R.layout.info_6,(ViewGroup) findViewById(R.id.info6));
                AlertDialog.Builder aDialog = new AlertDialog.Builder(Expo_Activity.this);

                aDialog.setView(layout);

                aDialog.setNegativeButton("close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                AlertDialog ad = aDialog.create();
                ad.show();}
        });


        Button Comp7_Button = (Button) findViewById(R.id.b7);
        Comp7_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context mContext = getApplicationContext();
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
                View layout = inflater.inflate(R.layout.info_7,(ViewGroup) findViewById(R.id.info7));
                AlertDialog.Builder aDialog = new AlertDialog.Builder(Expo_Activity.this);

                aDialog.setView(layout);

                aDialog.setNegativeButton("close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                AlertDialog ad = aDialog.create();
                ad.show();}
        });


        Button Comp8_Button = (Button) findViewById(R.id.b8);
        Comp8_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context mContext = getApplicationContext();
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
                View layout = inflater.inflate(R.layout.info_8,(ViewGroup) findViewById(R.id.info8));
                AlertDialog.Builder aDialog = new AlertDialog.Builder(Expo_Activity.this);

                aDialog.setView(layout);

                aDialog.setNegativeButton("close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                AlertDialog ad = aDialog.create();
                ad.show();}
        });


        Button Comp9_Button = (Button) findViewById(R.id.b9);
        Comp9_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context mContext = getApplicationContext();
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
                View layout = inflater.inflate(R.layout.info_9,(ViewGroup) findViewById(R.id.info9));
                AlertDialog.Builder aDialog = new AlertDialog.Builder(Expo_Activity.this);

                aDialog.setView(layout);

                aDialog.setNegativeButton("close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                AlertDialog ad = aDialog.create();
                ad.show();}
        });


        Button Comp10_Button = (Button) findViewById(R.id.b10);
        Comp10_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context mContext = getApplicationContext();
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
                View layout = inflater.inflate(R.layout.info_10,(ViewGroup) findViewById(R.id.info10));
                AlertDialog.Builder aDialog = new AlertDialog.Builder(Expo_Activity.this);

                aDialog.setView(layout);

                aDialog.setNegativeButton("close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                AlertDialog ad = aDialog.create();
                ad.show();}
        });


        Button Comp11_Button = (Button) findViewById(R.id.b11);
        Comp11_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context mContext = getApplicationContext();
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
                View layout = inflater.inflate(R.layout.info_11,(ViewGroup) findViewById(R.id.info11));
                AlertDialog.Builder aDialog = new AlertDialog.Builder(Expo_Activity.this);

                aDialog.setView(layout);

                aDialog.setNegativeButton("close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                AlertDialog ad = aDialog.create();
                ad.show();}
        });


        Button Comp12_Button = (Button) findViewById(R.id.b12);
        Comp12_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context mContext = getApplicationContext();
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
                View layout = inflater.inflate(R.layout.info_12,(ViewGroup) findViewById(R.id.info12));
                AlertDialog.Builder aDialog = new AlertDialog.Builder(Expo_Activity.this);

                aDialog.setView(layout);

                aDialog.setNegativeButton("close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                AlertDialog ad = aDialog.create();
                ad.show();}
        });

    }
}
