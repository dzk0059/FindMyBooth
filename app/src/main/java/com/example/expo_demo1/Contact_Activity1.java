package com.example.expo_demo1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

//Choose menu
//Use image from http://aaceal.com/event/auburn-university-american-society-of-civil-engineers-fall-2018-career-fair/
public class Contact_Activity1 extends AppCompatActivity {
    public static String e_mail_Address = "test1";


    public void setE_mail_Address(String a) {

        switch (a) {

            case "Admission":
                a = "admissions@auburn.edu";
                break;
            case "Financial":
                a = "finaid7@auburn.edu";
                break;
            case "Test":
                a = "blue1357a@gmail.com";
                break;

            case "Scholarships":

                a = "aualumni@auburn.edu";
                break;

            case "International":
                a = "intledu@auburn.edu";
                break;

            default:
                a = "Null";
        }


        this.e_mail_Address = a;

    }


    public String getE_mail_Address() {


        return e_mail_Address;
    }


    //Require codes
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_activity);

        String email_Address = "";


        //How test Scholarship Buttons
        Button mail_to_s_Office = (Button) findViewById(R.id.mail_to_S_office);
        mail_to_s_Office.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Move to next Sub3Activity (Screen Transition)
                setE_mail_Address("Auburn Career Fair Center");

                //Screen transition move from sub4 to sub1
                Intent move_sub4_sub41 = new Intent(Contact_Activity1.this, Contact_Activity2.class);
                startActivity(move_sub4_sub41);


            }
        });

        //How test office Buttons
        Button mail_to_Test = (Button) findViewById(R.id.test);
        mail_to_Test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Move to next Sub3Activity (Screen Transition)
                setE_mail_Address("App Admin(s)");

                //Screen transition move from sub4 to sub1
                Intent move_sub4_sub41 = new Intent(Contact_Activity1.this, Contact_Activity2.class);
                startActivity(move_sub4_sub41);


            }
        });


    }
}