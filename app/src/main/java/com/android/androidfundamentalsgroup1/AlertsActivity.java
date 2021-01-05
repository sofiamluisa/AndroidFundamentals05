package com.android.androidfundamentalsgroup1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

public class AlertsActivity extends AppCompatActivity {
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private TextView textViewDatePicker;
    private TextView textViewTimePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerts);

        textViewDatePicker = findViewById(R.id.textViewDatePicker);
        textViewTimePicker = findViewById(R.id.textViewTimePicker);


        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);
    }

    public void buttonOpenDatePicker(View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        textViewDatePicker.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, year, month, day);
        datePickerDialog.show();
    }

    public void buttonOpenTimePicker(View view) {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {

                        textViewTimePicker.setText(hourOfDay + ":" + minute);
                    }
                }, hour, minute, false);
        timePickerDialog.show();
    }

    public void buttonOpenDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.notice));
        builder.setMessage(getString(R.string.alert_title));

// add the buttons
        builder.setPositiveButton(getString(R.string.launch_app), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(AlertsActivity.this, getString(R.string.launch_app) + " " + getString(R.string.click), Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton(getString(R.string.reminde_me), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(AlertsActivity.this, getString(R.string.reminde_me) + " " + getString(R.string.click), Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(AlertsActivity.this, getString(R.string.cancel) + " " + getString(R.string.click), Toast.LENGTH_SHORT).show();
            }
        });

// create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}