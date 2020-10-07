package com.example.studyplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.studyplanner.ui.dashboard.Student;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;


public class login extends AppCompatActivity {
//    private DatabaseReference mDatabase;
    String roll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
//        mDatabase = FirebaseDatabase.getInstance().getReference();
        final EditText rollno = (EditText) findViewById(R.id.editText1);
        Button proceed = (Button) findViewById(R.id.button1);
        final Calendar cal = Calendar.getInstance();
        final int year = cal.get(Calendar.YEAR);
        final int month = cal.get(Calendar.MONTH);
//        final Intent intent = new Intent(login.this, MainActivity2.class);
        final Intent intent1 = new Intent(login.this, MainActivity.class);


        proceed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                roll   =  rollno.getText().toString();
                User a = User.getInstance();
                a.setroll(roll);

//                Bundle bundle = new Bundle();
//                bundle.putString("rollno", roll);
                String stu_year = roll.substring(0,4);

//                intent1.putExtras(bundle);
                if((month >= 1 && month<= 5)||(month == 12)) {
                    if (year == Integer.parseInt(stu_year)) {
                        a.setsem("Sem2");
                    }
                    if((year-1) == Integer.parseInt(stu_year)){
                        a.setsem("Sem4");
                    }
                    if((year-2) == Integer.parseInt(stu_year)){
                        a.setsem("Sem6");
                    }
                    if((year-3) == Integer.parseInt(stu_year)){
                        a.setsem("Sem8");
                    }
                    if((year-4) == Integer.parseInt(stu_year)) {
                        a.setsem("Sem10");
                    }
                }
                else {
                    if (year == Integer.parseInt(stu_year)) {
                        a.setsem("Sem1");
                    }
                    if((year-1) == Integer.parseInt(stu_year)){
                        a.setsem("Sem3");
                    }
                    if((year-2) == Integer.parseInt(stu_year)){
                        a.setsem("Sem5");
                    }
                    if((year-3) == Integer.parseInt(stu_year)){
                        a.setsem("Sem7");
                    }
                    if((year-4) == Integer.parseInt(stu_year))
                    {
                        a.setsem("Sem9");
                    }
                }
                startActivity(intent1);

//                if(Integer.parseInt(stu_year) <= (year-5) || Integer.parseInt(stu_year) <= year){
//                    intent1.putExtras(bundle);
//                    startActivity(intent1);
//                }
//                else {
//                    intent.putExtras(bundle);
////                    Toast.makeText(login.this, year + " " + month + " " + stu_year, Toast.LENGTH_SHORT).show();
//                    startActivity(intent);
//                }
            }
        });

    // [START basic_write]
//    private void writeNewUser(String roll) {
//        User user = new User(roll);
//
//        mDatabase.child("Rollno").setValue(user);
//    }
    // [END basic_write]

}

}