package com.example.expo_demo1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

//Use image from http://aaceal.com/event/auburn-university-american-society-of-civil-engineers-fall-2018-career-fair/
public class Contact_Activity2 extends AppCompatActivity {

    private EditText mEditTextTo;
    private EditText mEditTextSubject;
    private EditText mEditTextMessage;





    //Require codes
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_activity2);

        Contact_Activity1 sub4 = new Contact_Activity1();

        mEditTextTo = findViewById(R.id.to_input);
        mEditTextTo.setText(sub4.getE_mail_Address());

        mEditTextSubject = findViewById(R.id.subject_info_input);
        mEditTextMessage = findViewById(R.id.message_info_input);

        Button send_Button = findViewById(R.id.send_Button);
        send_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });

    }

    private void sendMail() {

        Contact_Activity1 sub4 = new Contact_Activity1();
        String reciptionlist = mEditTextTo.getText().toString();

        String[] recepitents = reciptionlist.split(",");
        //recepitents = new String[]{sub4.getE_mail_Address()};

        String subjects = mEditTextSubject.getText().toString();
        String message = mEditTextMessage.getText().toString();

        Intent send_mail =new Intent(Intent.ACTION_SEND);
        send_mail.putExtra(send_mail.EXTRA_EMAIL, recepitents);
        send_mail.putExtra(send_mail.EXTRA_SUBJECT, subjects);
        send_mail.putExtra(send_mail.EXTRA_TEXT,message);

        send_mail.setType("message/rfc822");
        startActivity(Intent.createChooser(send_mail, "Choose an email clinet"));



    }


}