package com.example.expo_demo1;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
public class MainActivity extends AppCompatActivity {

    EditText etEmail;
    EditText etPassword;
    private FirebaseAuth mAuth;
    String TAG = "Menu_Activity";

    Boolean check = false;

    ProgressBar pgBar;
    String stEmail;
    String stPassword;

    String email;


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        FirebaseApp.initializeApp(this);
        etEmail = (EditText)findViewById(R.id.E_mail);
        etPassword = (EditText)findViewById(R.id.password_text);
        pgBar = (ProgressBar) findViewById(R.id.progress_log);

        final  Intent move_main_menu = new Intent(MainActivity.this, Map_Activity.class);



        mAuth = FirebaseAuth.getInstance();


        //Sign In Button
        Button log_btnn = (Button) findViewById(R.id.signin_Button);
        log_btnn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                String stEmail = etEmail.getText().toString();
                String stPassword = etPassword.getText().toString();


                signIn(stEmail, stPassword);



            }
        });


        //Register In Button
        Button register_Button = (Button) findViewById(R.id.register_Button);
        register_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                stEmail = etEmail.getText().toString();
                stPassword = etPassword.getText().toString();


                createAccouunt(stEmail, stPassword);

            }
        });
    }

    public void  updateUI(FirebaseUser account){
        if(account != null){
            Toast.makeText(this,"U Signed In successfully",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this,"U Didnt signed in",Toast.LENGTH_LONG).show();
        }
    }

    public void createAccouunt(String email, String password) {

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }


                    }
                });

    }

    public void signIn(String email, String password) {

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {


                        if (!task.isSuccessful()) {
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Intent move_main_menu = new Intent(MainActivity.this, Menu_Activity.class);
                            startActivity(move_main_menu);
                            FirebaseUser user = mAuth.getCurrentUser();
                            etEmail.setText("");
                            etPassword.setText("");
                            updateUI(user);
                            Log.d(TAG, "signInWithEmail:success");

                        }




                        /**  if (task.isSuccessful()) {
                         // Sign in success, update UI with the signed-in user's information
                         Log.d(TAG, "signInWithEmail:success");
                         FirebaseUser user = mAuth.getCurrentUser();
                         // updateUI(user);
                         // pgBar.setVisibility(View.VISIBLE);
                         // pgBar.setVisibility(View.GONE);
                         letin();


                         } else {

                         // If sign in fails, display a message to the user.
                         Log.w(TAG, "signInWithEmail:failure", task.getException());
                         Toast.makeText(Menu_Activity.this, "Authentication failed.",
                         Toast.LENGTH_SHORT).show();
                         updateUI(null);
                         letout();
                         }
                         **/
                        // ...
                    }
                });


    }


    public String getemail() {


        return stEmail;

    }

    public void setemail() {

        email = stEmail;
    }

    public void letin() {

        check = true;
    }

    public void letout() {

        check = false;
    }
}
