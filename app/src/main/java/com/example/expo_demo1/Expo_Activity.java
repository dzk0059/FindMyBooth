package com.example.expo_demo1;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.content.Context;
import android.view.LayoutInflater;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Scanner;


//For Button1
public class Expo_Activity extends AppCompatActivity {
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference myref;
    private String userId;

    String TAG  = "profileActivity";
    String show_full_text = "";
    String user_email = "";

    //data from user
    String year = "";
    String major = "";
    String real_gpa;

    //convert data
    int numberyear;
    int numbermajor;
    double numbergpa;

    String uid = "";

    TextView view1;
    TextView view2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expo_activity);
        FirebaseApp.initializeApp(this);

        //from read activity


        //Access user info
        //FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myref = mFirebaseDatabase.getReference();
        FirebaseUser user = mAuth.getCurrentUser();
        userId = user.getUid();

        if (user != null) {

            user_email = user.getEmail();
            uid = user.getUid();
        }


        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };

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

        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                showData(dataSnapshot);
                setdivdeddata(year,major);
                numbergpa = Double.parseDouble(real_gpa);
                Toast.makeText(getApplicationContext(), "your status is " + numbergpa, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });


/***********************************/


        //color change


        //radomly choose numeric value

        //gpa
        //color change
        if (numberyear == 4 && numbergpa >= 3 && ( numbermajor == 3)) {

            colorb1.setTextColor(getResources().getColor(R.color.greenLight));
        }

        if (numberyear == 3 && numbergpa >= 2.5 && (numbermajor == 3)) {

            colorb2.setTextColor(getResources().getColor(R.color.greenLight));
        }
        //3
        if (numberyear == 4&& numbergpa >= 3.3 && (numbermajor == 1 | numbermajor == 3)) {

            colorb3.setTextColor(getResources().getColor(R.color.greenLight));
        }
        //4
        if (numberyear == 2 && numbergpa >=2.5 && (numbermajor == 1| numbermajor == 3 | numbermajor == 2)) {

            colorb4.setTextColor(getResources().getColor(R.color.greenLight));
        }
        //5
        if (numberyear > 4 && numbergpa >= 2.2 && (numbermajor == 2 | numbermajor == 1)) {

            colorb5.setTextColor(getResources().getColor(R.color.greenLight));
        }
        //6
        if (numberyear == 1 && numbergpa >= 2.0 && (numbermajor == 2 | numbermajor == 1| numbermajor == 3)) {

            colorb6.setTextColor(getResources().getColor(R.color.greenLight));
        }
        if (numberyear ==2 && numbergpa > 1 && (numbermajor == 3 )) {

            colorb7.setTextColor(getResources().getColor(R.color.greenLight));
        }
        if (numberyear ==3 && numbergpa > 2.8 && (numbermajor == 2 | numbermajor == 3)) {

            colorb8.setTextColor(getResources().getColor(R.color.greenLight));
        }
        if (numberyear == 1&& numbergpa > 2.6 && (numbermajor == 1 )) {

            colorb9.setTextColor(getResources().getColor(R.color.greenLight));
        }
        if (numberyear == 3 && numbergpa > 3.5 && (numbermajor == 1 | numbermajor == 2)) {

            colorb10.setTextColor(getResources().getColor(R.color.greenLight));
        }
        if (numberyear == 1 && numbergpa > 2.0 && (numbermajor == 2 | numbermajor == 3)) {

            colorb11.setTextColor(getResources().getColor(R.color.greenLight));
        }
        if (numberyear == 2 && numbergpa > 3.6 && (numbermajor == 3 )) {

            colorb12.setTextColor(getResources().getColor(R.color.greenLight));
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

    public void showData(DataSnapshot dataSnapshot) {

        for(DataSnapshot ds :dataSnapshot.getChildren()){

            User uInfo = new User();
            uInfo.setEmail(ds.child(userId).getValue(User.class).getEmail()); //set the email
            uInfo.setFulltext(ds.child(userId).getValue(User.class).getFulltext()); //set the name

            //display all the information
            Log.d(TAG, "showData: name: " + uInfo.getFulltext());
            Log.d(TAG, "showData: email: " + uInfo.getEmail());

            show_full_text = uInfo.getFulltext();

            Scanner s = new Scanner(show_full_text).useDelimiter("/");

            year = s.next();
            real_gpa = s.next();
            major= s.next();

           // numbergpa = Double.valueOf(real_gpa);
        }



    }



    public void setdivdeddata(String readgrad, String readmajor) {


        //year
        if(readgrad == "Spring 2020"){

            numberyear = 1;
        }
        else if(readgrad == "Summer 2020") {

            numberyear = 2;

        }else if(readgrad == "Fall 2020") {

            numberyear = 3;

        }
        else {

            numberyear = 4;
        }


        //major
        if(readmajor == "Accounting"){

            numbermajor = 1;
        }
        else if(readmajor == "Business") {

            numbermajor = 2;

        }else {

            numbermajor = 3;
        }
    }


}
