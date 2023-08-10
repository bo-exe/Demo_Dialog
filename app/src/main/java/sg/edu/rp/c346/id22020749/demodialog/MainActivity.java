package sg.edu.rp.c346.id22020749.demodialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnDemo1;
    Button btnDemo2;
    Button btnDemo3;
    Button btnDemo4;
    Button btnDemo5;
    Button btnDemo6;
    TextView tvDemo2;
    TextView tvDemo3;
    TextView tvDemo4;
    TextView tvDemo5;
    TextView tvDemo6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDemo1 = findViewById(R.id.buttonDemo1);
        btnDemo2 = findViewById(R.id.buttonDemo2);
        tvDemo2 = findViewById(R.id.textViewDemo2);
        btnDemo3 = findViewById(R.id.buttonDemo3);
        tvDemo3 = findViewById(R.id.textViewDemo3);
        btnDemo4 = findViewById(R.id.buttonDemo4);
        tvDemo4 = findViewById(R.id.textViewDemo4);
        btnDemo5 = findViewById(R.id.ButtonDatePicker);
        tvDemo5 = findViewById(R.id.textViewDatePicker);
        btnDemo6 = findViewById(R.id.buttonTimePicker);
        tvDemo6 = findViewById(R.id.textViewTimePicker);

        btnDemo1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                /*
                myBuilder.setTitle("Demo 1-Simple Dialog");
                myBuilder.setMessage("I can develop Android App.");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Close", null);
                */

                myBuilder.setTitle("Congratulations");
                myBuilder.setMessage("You have completed a single Dialog Box.");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("DISMISS", null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnDemo2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                myBuilder.setTitle("Demo 2 Buttons Dialog");
                myBuilder.setMessage("Select one of the Buttons below.");
                myBuilder.setCancelable(false);

                myBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You have selected Positive.");
                    }
                });

                myBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You have selected Negative.");
                    }
                });

                btnDemo3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        LayoutInflater inflater =
                                (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        View viewDialog = inflater.inflate(R.layout.layout, null);

                        final EditText etInput = viewDialog.findViewById(R.id.editTextInput);

                        AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                        myBuilder.setView(viewDialog);
                        myBuilder.setTitle("Demo 3-Text Input Dialog");
                        myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Extract the text entered by the user
                                String message = etInput.getText().toString();
                                // Set the text to the TextView
                                tvDemo3.setText(message);
                            }
                        });
                        myBuilder.setNegativeButton("CANCEL", null);
                        AlertDialog myDialog = myBuilder.create();
                        myDialog.show();
                    }
                });

                btnDemo4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        LayoutInflater inflater =
                                (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        View viewDialog = inflater.inflate(R.layout.layoutdemo4, null);

                        EditText etInput1 = viewDialog.findViewById(R.id.editTextText2);
                        EditText etInput2 = viewDialog.findViewById(R.id.editTextText3);
                        String InputString1 = etInput1.getText().toString();
                        String InputString2 = etInput2.getText().toString();
                        int Sum = Integer.parseInt(InputString1) + Integer.parseInt(InputString2);

                        AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                        myBuilder.setView(viewDialog);
                        myBuilder.setTitle("Exercise 3");
                        myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Extract the text entered by the user
                                String message = "The sum is " + Sum;
                                // Set the text to the TextView
                                tvDemo4.setText(message);
                            }
                        });
                        myBuilder.setNegativeButton("CANCEL", null);
                        AlertDialog myDialog = myBuilder.create();
                        myDialog.show();
                    }
                });

                btnDemo5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                tvDemo5.setText("Date: " + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        };

                        Calendar calendar = Calendar.getInstance();
                        int currentYear = calendar.get(Calendar.YEAR);
                        int currentMonth = calendar.get(Calendar.MONTH);
                        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);

                        DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this,
                                myDateListener, currentYear, currentMonth, currentDay);
                        myDateDialog.show();
                    }
                });

                btnDemo6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                String AM_PM;
                                if (hourOfDay >= 12) {
                                    AM_PM = "PM";
                                    if (hourOfDay > 12) {
                                        hourOfDay -= 12;
                                    }
                                } else {
                                    AM_PM = "AM";
                                    if (hourOfDay == 0) {
                                        hourOfDay = 12;
                                    }
                                }
                                tvDemo5.setText("Time: " + hourOfDay + ":" + minute + " " + AM_PM);
                            }
                        };

                        Calendar calendar = Calendar.getInstance();
                        int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                        int currentMinute = calendar.get(Calendar.MINUTE);

                        TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this,
                                myTimeListener, currentHour, currentMinute, false);
                        myTimeDialog.show();
                    }
                });
            }
        });
    }
}

