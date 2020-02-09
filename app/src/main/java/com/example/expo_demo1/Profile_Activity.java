package com.example.expo_demo1;

import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.SAXParser;
//Button 3
public class Profile_Activity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {



    TextView view1;
    String TAG  = "profileActivity";
    public static String output ="";
    String Graduation_text = "";
    String fullText = "";

    String user_email = "";
    String GPA_Text;
    String uid = "";
    String major_Text = "";

    EditText GPA_Info;






    //When it is starts
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.

    }


    //Oncrete status
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);
        FirebaseApp.initializeApp(this);

        //Edit Text info
        GPA_Info = findViewById(R.id.gpa_info) ;


        //Access user info
        //FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {

            user_email = user.getEmail();
            uid = user.getUid();
        }






        //Graduation Info
        Spinner grad_Spinnner = (Spinner) findViewById(R.id.gradation_info);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
                (this,R.array.gradation_info, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        grad_Spinnner.setAdapter(adapter);
        grad_Spinnner.setOnItemSelectedListener(this);


        //major Info
        //Graduation Info
        Spinner major_Spinner = (Spinner) findViewById(R.id.major_info);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource
                (this,R.array.major_info, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        major_Spinner.setAdapter(adapter1);
        major_Spinner.setOnItemSelectedListener(this);



        //Save Button   -- updating data file
        Button save_button = (Button) findViewById(R.id.save_button);
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, user_email);
                // Write a message to the database

                FirebaseDatabase database = FirebaseDatabase.getInstance();

                //Data 라는 Reference 추가를 해준다
                DatabaseReference myRef = database.getReference("Data").child(uid);
                setGPA_Text();
                setFullText();

                //HashTable
                HashMap<String, String> chats = new HashMap<String, String>();
                chats.put("email", user_email);
                chats.put("FullText", fullText);

                myRef.setValue(chats);

                if (user_email == "") {

                    Log.d(TAG, "Type");

                }

                //Display output
                TextView test3 = findViewById(R.id.view3);
                test3.setText(fullText);

            }
        });


    }

    //Itemselcted
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(parent.getId() == R.id.gradation_info)
        {
            Graduation_text = parent.getItemAtPosition(position).toString();

        }
        else if(parent.getId() == R.id.major_info)
        {
            major_Text = parent.getItemAtPosition(position).toString();
        }


        //Display output
        TextView test1 = findViewById(R.id.view1);
        test1.setText(Graduation_text);

        //Display output
        TextView test2 = findViewById(R.id.view2);
        test2.setText(major_Text);

    }



    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    //Set full text
    public void setFullText() {
        fullText = Graduation_text + "/" + GPA_Text + "/" + major_Text;
    }

    //Set GPA text
    public void setGPA_Text() {

        GPA_Text = GPA_Info.getText().toString();
    }



}
