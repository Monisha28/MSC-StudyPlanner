package com.example.studyplanner.ui.dashboard;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studyplanner.DataHolder;
import com.example.studyplanner.MainActivity;
import com.example.studyplanner.MainActivity3;
import com.example.studyplanner.R;
import com.example.studyplanner.User;
import com.example.studyplanner.login;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;


public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    Activity context;


    TextView txtData;
    String a;
    String[] getData;
    RecyclerView recyclerView;
    List<Student> studentList = new ArrayList<>();
    String sub,exam,date,roll,unit = null;
    int progress = 0;
    private static final String TAG = "dashboard";


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        MainActivity activity = (MainActivity) getActivity();
        getData = activity.sendData();
//        User u = User.getInstance();
//        roll = u.getroll();
//
        SharedPreferences pref = getActivity().getSharedPreferences("Login", Context.MODE_PRIVATE);
        roll = pref.getString("rollno", "empty");

        sub = getData[0];
        exam = getData[1];
        date = getData[2];
        unit = getData[3];



//        setDummyData();
//        mDatabase = FirebaseDatabase.getInstance().getReference();
        Toast.makeText(getActivity(),roll,Toast.LENGTH_SHORT).show();


        mFirebaseInstance = FirebaseDatabase.getInstance();

        // get reference to 'users' node
        mFirebaseDatabase = mFirebaseInstance.getReference("test");

        if(sub != null){
             createUser(sub,unit,exam,date, progress);}


        View rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);

//        // store app title to 'app_title' node
//        mFirebaseInstance.getReference("course").setValue("msc");
//
//        // app_title change listener
//        mFirebaseInstance.getReference("course").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                Log.e(TAG, "App title updated");
//
//                String appTitle = dataSnapshot.getValue(String.class);
//                Toast.makeText(getActivity(),appTitle,Toast.LENGTH_SHORT).show();
//                // update toolbar title
////                getSupportActionBar().setTitle(appTitle);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.e(TAG, "Failed to read app title value.", error.toException());
//                Toast.makeText(getActivity(),"fail",Toast.LENGTH_SHORT).show();
//            }
//        });

        recyclerView = (RecyclerView) rootView.findViewById(R.id.myrec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        mFirebaseDatabase.child(roll).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    for (DataSnapshot npsnapshot : dataSnapshot.getChildren()){
                        Student s = npsnapshot.getValue(Student.class);
                        studentList.add(s);
                    }
                    final customAdapter customAdapter = new customAdapter(studentList);
                    recyclerView.setAdapter(customAdapter);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });




//        mDatabase.child("2016242013").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//
//                Student student = dataSnapshot.getValue(Student.class);
//
//                Log.d(TAG, "User name: " + student.getTest() + ", date " + student.getDate());
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException());
//            }
//        });

//         a = getArguments() != null ? getArguments().getString("a") : "null";

//            String[] myArray = new String[5];
//            if (getArguments() != null) {
//               myArray = getArguments().getStringArray("array");
//            }
//        String a;
//        Bundle bundle = this.getArguments();
//        if (bundle != null) {
//            a = bundle.getString("a","null");
//        }
//            String a = getArguments().getString("Date");


//            TextView sub_name = (TextView) rootView.findViewById(R.id.sub_name);
//            sub_name.setText(getData[0]);
//            TextView exam_name = (TextView) rootView.findViewById(R.id.exam_name);
//            exam_name.setText(getData[1]);
//            TextView exam_date = (TextView) rootView.findViewById(R.id.exam_date);
//            exam_date.setText(getData[2]);
//        Button proceed = (Button) rootView.findViewById(R.id.button11);
//        recyclerView = (RecyclerView) rootView.findViewById(R.id.myrec);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        setDummyData();
//        final customAdapter customAdapter = new customAdapter(studentList);
//        recyclerView.setAdapter(customAdapter);
////        customAdapter.notifyDataSetChanged();
//        if(getData.length != 0 ) {
//            customAdapter.updateData(studentList);
//            sub.add(getData[0]);
//            exam.add(getData[1]);
//            date.add(getData[2]);
//            setDummyData();
////            Toast.makeText(getActivity(), studentList.size(), Toast.LENGTH_SHORT).show();

//        }



//        proceed.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                // Perform action on click
//                customAdapter.updateData(studentList);
//                String roll = a.getText().toString();
//                sub.add(getData[0]);
//                exam.add(roll);
//                date.add(roll);
//                setDummyData();
//            }
//        });

//        customAdapter.setOnItemClickListener(this);

//        customAdapter.setData(studentList);

//                dashboardViewModel =
//                ViewModelProviders.of(this).get(DashboardViewModel.class);
//        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
//        final TextView textView = root.findViewById(R.id.text_dashboard);
//        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
            return rootView;
    }

//    private void setDummyData(){
//
//        for(int i=0;i<sub.size();i++)
//        {
//            Student s = new Student();
//            s.setTest(exam.get(i));
//            s.setDate(date.get(i));
//            s.setSubName(sub.get(i));
//            studentList.add(s);
////            Toast.makeText(getActivity(),studentList.size(),Toast.LENGTH_SHORT).show();
//
//        }
//}



    private void createUser(String sub, String unit, String exam, String date, int progress) {
        // TODO
        // In real apps this userId should be fetched
        // by implementing firebase auth
        if (TextUtils.isEmpty(roll)) {
            roll = mFirebaseDatabase.push().getKey();
        }
        String id =  mFirebaseDatabase.push().getKey();
        Student test = new Student(sub, unit, exam, date, progress);
        mFirebaseDatabase.child(roll).child(id).setValue(test);
        addUserChangeListener();
    }

    private void addUserChangeListener() {
        // User data change listener
        mFirebaseDatabase.child(roll).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               Student test = dataSnapshot.getValue(Student.class);

                // Check for null
                if (test == null) {
                    Log.e(TAG, "test data is null!");
                    return;
                }
                Toast.makeText(getActivity(),"data added",Toast.LENGTH_SHORT).show();
                Log.e(TAG, "User data is changed!" + test.getDate());

                // Display newly updated name and email
//                txtDetails.setText(user.name + ", " + user.email);
//
//                // clear edit text
//                inputEmail.setText("");
//                inputName.setText("");
//
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.e(TAG, "Failed to read user", error.toException());
            }
        });
    }


//    public void basicReadWrite() {
//        // [START write_message]
//        // Write a message to the database
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("message");
//
//        myRef.setValue("Hello, World!");
//        // [END write_message]
//
//        // [START read_message]
//        // Read from the database
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                String value = dataSnapshot.getValue(String.class);
//                Log.d(TAG, "Value is: " + value);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException());
//            }
//        });
//    }
}
