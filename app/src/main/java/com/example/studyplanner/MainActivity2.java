package com.example.studyplanner;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    ArrayAdapter adapter;
    String[] Sem1 = {"Communicative English", "Mathematics – I", "Applied Physics", "Chemistry of Materials", "Fundamentals of Computing", "Communication Skills Laboratory", "Computing Laboratory"};
    String[] Sem2 = {"Technical Communication", "Discrete Mathematics", "Mathematics – II", "Digital Systems", "Programming in C", "Digital Systems Laboratory", "Programming in C Laboratory"};
    String[] Sem3 = {"Mathematics - III", "Data Structures", "Database Management Systems", "Microprocessors and Applications", "Obect Oriented Programming in C++", "Data Structures Laboratory", "Database Management Systems Laboratory", "Object Oriented Programming Laboratory"};
    String[] Sem4 = {"Combinatorics and Graph Theory", "Computer Architecture", "Java and Internet Programming", "Operating Systems", "Theory of Computation", "Java and Internet Programming Laboratory", "Operating Systems Laboratory", "XML and Web Services Laboratory"};
    String[] Sem5 = {"Applied Statistics", "Computer Networks", "Design and Analysis of Algorithms", "Software Engineering", "Data Mining and warehousing", "Elective - I", "Data Mining and Warehousing Laboratory", "GUI Applications Laboratory"};
    String[] Sem6 = {"Probability", "Queuing Theory and Reliability", "Computer Graphics and Multimedia", "Object Oriented Analysis and Design", "Network Management", "Environmental Science and Engineering", "Elective – II", "Case Tools Laboratory", "Computer Graphics and Multimedia Laboratory"};
    String[] Sem7 = {"Industrial Project"};
    String[] Sem8 = {"Numerical Methods", "Principles of Compiler Design", "Software Testing and Quality Assurance", "Cloud Computing", "Software Project Management", "Elective – III", "Software Testing Laboratory", "Creative and Innovative Project"};
    String[] Sem9 = {"Operations Research", "Information Management", "Mobile and Pervasive Computing", "Service Oriented Architecture", "Elective – IV", "Elective – V", "Mobile Applications Development (Mini Project)", "Service Oriented Architecture Laboratory"};
    String[] Sem10 = {"Project Work"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle b = getIntent().getExtras();
        String whichsem = b.getString("sem");
//        Toast.makeText(this,whichsem,Toast.LENGTH_SHORT).show();

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null)
        {
            actionBar.setTitle(whichsem);
        }
        switch (whichsem)
        {
            case "Sem1":
                adapter = new ArrayAdapter<String>(this, R.layout.name, Sem1);
                break;
            case "Sem2":
                adapter = new ArrayAdapter<String>(this, R.layout.name, Sem2);
                break;
            case "Sem3":
                adapter = new ArrayAdapter<String>(this, R.layout.name, Sem3);
                break;
            case "Sem4":
                adapter = new ArrayAdapter<String>(this, R.layout.name, Sem4);
                break;
            case "Sem5":
                adapter = new ArrayAdapter<String>(this, R.layout.name, Sem5);
                break;
            case "Sem6":
                adapter = new ArrayAdapter<String>(this, R.layout.name, Sem6);
                break;
            case "Sem7":
                adapter = new ArrayAdapter<String>(this, R.layout.name, Sem7);
                break;
            case "Sem8":
                adapter = new ArrayAdapter<String>(this, R.layout.name, Sem8);
                break;
            case "Sem9":
                adapter = new ArrayAdapter<String>(this, R.layout.name, Sem9);
                break;
            case "Sem10":
                adapter = new ArrayAdapter<String>(this, R.layout.name, Sem10);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + whichsem);
        }


        final ListView listView = (ListView) findViewById(R.id.sub_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                String getrec =(String) (listView.getItemAtPosition(position));
//Create the bundle
                Bundle bundle = new Bundle();
//Add your data to bundle
                bundle.putString("Subject", getrec);
//Add the bundle to the intent
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


    }
}