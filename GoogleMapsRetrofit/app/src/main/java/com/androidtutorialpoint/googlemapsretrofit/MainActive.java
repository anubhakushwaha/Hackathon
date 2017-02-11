package com.androidtutorialpoint.googlemapsretrofit;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActive extends AppCompatActivity {


    EditText ed,ed1;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.active_main);
        ed= (EditText) findViewById(R.id.editText);
        ed1= (EditText) findViewById(R.id.editText1);
        ed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day

                // date picker dialog
                datePickerDialog = new DatePickerDialog(MainActive.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                ed.setText((year-2000) + "-"
                                        + (monthOfYear + 1) + "-" + dayOfMonth);

                            String date =year+"-"+monthOfYear+"-"+dayOfMonth;
                                SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
                                Calendar c = Calendar.getInstance();

                                try {
                                    c.setTime(sdf.parse(date));
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                int week1 = c.get(Calendar.WEEK_OF_YEAR);
                                c.add(Calendar.MONTH, 9);  // number of days to add, can also use Calendar.DAY_OF_MONTH in place of Calendar.DATE

                                SimpleDateFormat sdf1 = new SimpleDateFormat("yy-MM-dd");
                                String output = sdf1.format(c.getTime());
                                ed1.setText(output);
                                Toast.makeText(getApplicationContext(),output+"   "+week1,Toast.LENGTH_LONG).show();

                                gen(week1);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();

            }
        });

    }

    public void gen(int week1)
    {
        Calendar c = Calendar.getInstance();
        //System.out.println("Current time => " + c.getTime());
        final int week2 = c.get(Calendar.WEEK_OF_YEAR);
        int calendarWeekDifference = (week2 - week1);
        Toast.makeText(getApplicationContext(),""+week2,Toast.LENGTH_LONG).show();
    }
}
