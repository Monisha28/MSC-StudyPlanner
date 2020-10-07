package com.example.studyplanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.DatePickerDialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.studyplanner.ui.dashboard.DashboardFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.security.auth.Subject;

public class MainActivity3 extends AppCompatActivity {


    // datepicker
    private static final String TAG = "MainActivity3";
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    //MultipleSelection spinner object
    MultipleSelectionSpinner mSpinner;

    //List which hold multiple selection spinner values
    List<String> list = new ArrayList<String>();

    // multiSelect
    String examname,unit,date,subject = "none";
//    ArrayList<Integer> mUserItems = new ArrayList<>();
    DashboardFragment myObj = new DashboardFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);this.setFinishOnTouchOutside(false);


        final Bundle bundle = getIntent().getExtras();
        //Extract the Subject data…
        subject = bundle.getString("Subject");
        TextView subName = (TextView)findViewById(R.id.subject);
        subName.setText(subject);


        // Get reference of widgets from XML layout
        final Spinner spinner = (Spinner) findViewById(R.id.spinner1);

        // Initializing a String Array
        String[] spinnerValue = {
                "Select Exam",
                "Assesment 1",
                "Assesment 2",
                "End Semester"
          };


        final List<String> examList = new ArrayList<>(Arrays.asList(spinnerValue));

        // Initializing an ArrayAdapter
        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this,R.layout.exam_name,examList){
            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {// Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                }
                else
                {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                }
                else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        spinnerArrayAdapter.setDropDownViewResource(R.layout.exam_name);
        spinner.setAdapter(spinnerArrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                examname = (String) parent.getItemAtPosition(position);
                // If user change the default selection
                // First item is disable and it is used for hint
                if(position > 0){
                    // Notify the selected item text
//                    bundle1.putString("Examname", examname);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //datepickerStart
        mDisplayDate = (TextView) findViewById(R.id.tvDate);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        MainActivity3.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });


        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                date = month + "/" + day + "/" + year;
                mDisplayDate.setText(date);
            }
        };
        //datepickerEnd

        mSpinner = findViewById(R.id.mSpinner);

        //adding items to list
        list.add("Unit 1");
        list.add("Unit 2");
        list.add("Unit 3");
        list.add("Unit 4");
        list.add("Unit 5");

        //set items to spinner from list
        mSpinner.setItems(list);
        unit = mSpinner.getSelectedItemsAsString();
//        Toast.makeText(MainActivity3.this, unit, Toast.LENGTH_SHORT).show();

        Button button= (Button) findViewById(R.id.add_ass);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent i=new Intent(MainActivity3.this, MainActivity.class);
//                DashboardFragment myObj = new DashboardFragment();
//                Bundle bundle1 = new Bundle();
                Toast.makeText(MainActivity3.this, "Exam Added", Toast.LENGTH_SHORT).show();
//                myObj.doWhatYouWant("this is passed as string object to fragment");
//                bundle1.putString("Units", unit);
//                bundle1.putString("Date", "10/12");
//                myObj.setArguments(bundle1);
//                DataHolder.getInstance().setItem(subject);
                i.putExtra("Exam", new String[] {subject, examname, date, unit});
//                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });

    }


}