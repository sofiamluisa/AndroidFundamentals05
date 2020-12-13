package com.android.androidfundamentalsgroup1;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private final String ANDROID_DOCS = "https://developer.android.com/";
    private final String TAG = "MainActivity";

    public static final Pattern EMAIL_ADDRESS = null;


    private List<Email> emails;

    //TEMA 2
    //TEMA 2
    private TextView loginTextView;
    private EditText editTextemail;
    private EditText editTextPhoneNr;
    private CheckBox checkboxTC;
    private Button submitButton;
    private Spinner spinnerVersionsAndroid;
    private TextView submitTextView;

    //TEMA 3

    private List<Student> studentList;
    private RecyclerView recyclerViewStudents;
    private Button buttonSnow;
    private Button buttonBells;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //TEMA EMAIL
        // setContentView(R.layout.views_tema_email);
//        editTextemail = findViewById(R.id.emailAddressText);
//        editTextPhoneNr = findViewById(R.id.editTextPhone);
//        checkboxTC = findViewById(R.id.checkBox);
//        submitButton = findViewById(R.id.submitButton);
//        submitTextView = findViewById(R.id.submitTextView);
//
//        submitButton.setOnClickListener(new View.OnClickListener() {
//            @SuppressLint("SetTextI18n")
//            @Override
//            public void onClick(View view) {
//                String contentEmail = editTextemail.getText().toString();
//                String contentPhone = editTextPhoneNr.getText().toString();
//
//                Boolean completed = true;
//                if (!isEmailValid(contentEmail)) {
//                    editTextemail.setError(getString(R.string.mail_not_valid));
//                    completed = false;
//                }
//                if (!isPhoneValid(contentPhone)) {
//                    editTextPhoneNr.setError(getString(R.string.phone_not_valid));
//                    completed = false;
//                }
//                if (completed) {
//                    Boolean tcChecked = false;
//                    if (checkboxTC.isChecked())
//                        tcChecked = true;
//                    submitTextView.setText(getString(R.string.email) + ": " + contentEmail
//                            + "\n" + getString(R.string.phone) + ": " + contentPhone
//                            + "\n" + getString(R.string.a_accept_t_and_c) + ": "
//                            + tcChecked.toString());
//                }
//            }
//        });


        //TEMA SCROLL VIEW
//        setContentView(R.layout.views_tema_scroll);

        //TEMA SPINNER
//        setContentView(R.layout.views_tema_spinner);
//        setupSpinnerAdapter();

//        TEMA FRAME
//        setContentView(R.layout.views_tema_frame);

        //TEMA RECYCLERVIEW
        //  setContentView(R.layout.views_tema_recycler_view_students);

        // displayStudents();
        //TEMA CODECHALLANGE3
        setContentView(R.layout.views_tema_codechallange3);
        buttonSnow = findViewById(R.id.buttonSnow);
        buttonSnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "It's snowing", Toast.LENGTH_LONG).show();
            }
        });

        buttonBells = findViewById(R.id.buttonBells);
        buttonBells.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "The bells are ringing", Toast.LENGTH_LONG).show();
            }
        });
    }



    //TEMA EMAIL

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    //TEMA SPINNER

    private List<String> getSpinnerAndroidDataSource() {
        List<String> androidExample = new ArrayList<>();
        androidExample.add("Cupcake");
        androidExample.add("Pie");
        androidExample.add("Eclair");
        androidExample.add("Donut");
        return androidExample;
    }

    private ArrayAdapter<String> getSpinnerAdapter() {
        return new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getSpinnerAndroidDataSource());
    }

    private void setupSpinnerAdapter() {
        spinnerVersionsAndroid = findViewById(R.id.spinnerVersionsAndroid);
        spinnerVersionsAndroid.setAdapter(getSpinnerAdapter());
        spinnerVersionsAndroid.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long itemId) {
        List<String> androidExample = getSpinnerAndroidDataSource();
        String selectVersion = androidExample.get(position);
        Toast.makeText(MainActivity.this, selectVersion, Toast.LENGTH_LONG).show();
    }

    //RECYCLERVIEW

    private void students() {
        studentList = new ArrayList<>();
        Student student = null;
        for (int i = 0; i < 25; i++) {
            student = new Student("firstName " + i, "lastName " + i);
            studentList.add(student);
        }
    }

    private void setStudentLayoutManager() {
        recyclerViewStudents = findViewById(R.id.recyclerViewStudents);
        recyclerViewStudents.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setStudentAdapter() {
        recyclerViewStudents.setAdapter(new StudentAdapter(this, studentList));
    }

    private void displayStudents() {
        students();
        setStudentLayoutManager();
        setStudentAdapter();
    }


    private boolean isEmailValid(String email) {
        if (email == null || email.length() <= 0) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }
    }

    private boolean isPhoneValid(String phone) {
        if (phone == null || phone.length() <= 0) {
            return false;
        } else {
            return Patterns.PHONE.matcher(phone).matches();
        }

    }

}



