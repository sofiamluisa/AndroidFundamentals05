package com.android.androidfundamentalsgroup1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.androidfundamentalsgroup1.activities.FormActivity;
import com.android.androidfundamentalsgroup1.activities.SecondActivity;
import com.android.androidfundamentalsgroup1.fragments.SumActivity;
import com.android.androidfundamentalsgroup1.recycler_view.Email;
import com.android.androidfundamentalsgroup1.recycler_view.EmailAdapter;
import com.android.androidfundamentalsgroup1.styles.StyleSamplesActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private final String ANDROID_DOCS = "https://developer.android.com/";
    public static final String MESSAGE_KEY = "message";
    private static final int REQUEST_CODE_MESSAGE = 12;
    private final String TAG = "MainActivity";

    private TextView oneTextView;
    private EditText editTextUserFullName;
    private CheckBox checkBoxTermsAndConditions;
    private SeekBar seekBarCountChallenges;
    private TextView textViewPurpleContent;
    private Button buttonGetContent;
    private WebView webViewAndroid;
    private Spinner spinnerAndroidVersions;
    private RecyclerView recyclerViewEmails;
    private EditText editTextMessage;

    private List<Email> emails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // seteaza layout-ul asociat activatii MainActivity
        // setContentView(R.layout.activity_main);
        // asociem views_sample_1 ca layout al activitatii MainActivity
        // setContentView(R.layout.views_sample_1);
        // displayViewsSample1();

        // run ScrollView sample
        // setContentView(R.layout.views_sample_scroll_view);

        // run WebView sample
        // setContentView(R.layout.views_sample_web_view);
        // loadUrlInWebView();

        // run Spinner sample
        // setContentView(R.layout.views_sample_spinner);
        // setupSpinnerAdapter();

        // run RecyclerView sample
        // setContentView(R.layout.views_sample_recycler_view);
        // displayEmailsList();

        setContentView(R.layout.activity_main);
        editTextMessage = findViewById(R.id.ediTextMessage);

        Logging.show(TAG, "onCreate");

        int result = sum(10, 5, 4);
        Logging.show("MainActivity result = ", result + "");
        result++;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Logging.show(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Logging.show(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Logging.show(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Logging.show(TAG, "onStop");
    }

    private int sum(int a, int b, int c) {
        int result = a / b;
        return result + c;
    }

    // RecyclerView implementation
    // get data source
    private void inbox() {
        emails = new ArrayList<>();
        Email email = null;
        for (int i = 0; i < 25; i++) {
            email = new Email(0, "Magda " + i, "Hello Android " + i, "This is an intro about Android");
            emails.add(email);
        }
    }

    // step 4 = Define the LayoutManager in activity
    // set the layout manager, in our case LinearLayoutManager because it's a list of emails
    private void setEmailsLayoutManager() {
        recyclerViewEmails = findViewById(R.id.recyclerViewEmails);
        recyclerViewEmails.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setEmailsAdapter() {
        recyclerViewEmails.setAdapter(new EmailAdapter(this, emails));
    }

    private void displayEmailsList() {
        // data source - checked
        inbox();

        // layout manager - checked
        setEmailsLayoutManager();

        // adapter - checked
        setEmailsAdapter();
    }

    // Spinner implementation
    // step 1 = get the data source for the Spinner
    private List<String> getSpinnerAndroidDataSource() {
        List<String> androidVersions = new ArrayList<>();
        androidVersions.add("Cupcake");
        androidVersions.add("Donut");
        androidVersions.add("Eclair");
        androidVersions.add("KitKat");
        androidVersions.add("Pie");
        return androidVersions;
    }

    // step 2 = get the adapter
    private ArrayAdapter<String> getSpinnerAdapter() {
        return new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getSpinnerAndroidDataSource());
    }

    // step 3 = set the adapter to the spinner
    private void setupSpinnerAdapter() {
        spinnerAndroidVersions = findViewById(R.id.spinnerAndroidVersions);
        spinnerAndroidVersions.setAdapter(getSpinnerAdapter());
        // let the Spinner to know that we implemented the setOnItemSelectedListener event at the Activity level
        spinnerAndroidVersions.setOnItemSelectedListener(this);
    }

    private void loadUrlInWebView() {
        webViewAndroid = findViewById(R.id.webViewAndroid);
        WebSettings webSettings = webViewAndroid.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webViewAndroid.loadUrl(ANDROID_DOCS);
    }

    private void displayViewsSample1() {
        oneTextView = findViewById(R.id.firstTextView);
        oneTextView.setText(R.string.new_text);

        editTextUserFullName = findViewById(R.id.editTextFullName);
        editTextUserFullName.setText(R.string.default_full_name);

        checkBoxTermsAndConditions = findViewById(R.id.checkboxTermsAndConditions);
        if (checkBoxTermsAndConditions.isChecked()) {
            checkBoxTermsAndConditions.setChecked(false);
            oneTextView.setText(R.string.checkbox_checked);
        } else {
            checkBoxTermsAndConditions.setChecked(true);
            oneTextView.setText(R.string.checkbox_unchecked);
        }

        checkBoxTermsAndConditions.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()) {
                    editTextUserFullName.setText(R.string.checkbox_state_checked);
                } else {
                    editTextUserFullName.setText(R.string.checkbox_state_unchecked);
                }
            }
        });

        seekBarCountChallenges = findViewById(R.id.seekBarChallenges);
        seekBarCountChallenges.setProgress(5);

        textViewPurpleContent = findViewById(R.id.textViewPurpleContent);

        buttonGetContent = findViewById(R.id.buttonGetContent);
        // block comment/un-comment CTRL + Shift + /
        /*buttonGetContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // preluam contentul din EditText si il convertim in String
                String contentFromEditText = editTextUserFullName.getText().toString();
                if (contentFromEditText != null && contentFromEditText.length() > 0) {
                    textViewPurpleContent.setText(contentFromEditText);
                } else {
                    editTextUserFullName.setError(getString(R.string.error_missing_text));
                }
            }
        });*/
    }

    public void buttonGetContentOnClick(View view) {
        // preluam contentul din EditText si il convertim in String
        String contentFromEditText = editTextUserFullName.getText().toString();
        if (contentFromEditText != null && contentFromEditText.length() > 0) {
            textViewPurpleContent.setText(contentFromEditText);
        } else {
            editTextUserFullName.setError(getString(R.string.error_missing_text));
        }
    }

    // params: list, child, position, adapter.getItemId(position)
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long itemId) {
        List<String> androidVersions = getSpinnerAndroidDataSource();
        String selectedVersion = androidVersions.get(position);
        Toast.makeText(MainActivity.this, selectedVersion, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void buttonOpenSecondActivityOnClick(View view) {
        Intent secondActivity = new Intent(MainActivity.this, SecondActivity.class);
        secondActivity.putExtra(MESSAGE_KEY, getString(R.string.hello_message));
        startActivity(secondActivity);
    }

    public void buttonCommunicationBetweenActivitiesOnClick(View view) {
        Intent secondActivity = new Intent(MainActivity.this, SecondActivity.class);
        String message = editTextMessage.getText().toString();
        if (message != null && message.length() > 0) {
            secondActivity.putExtra(MESSAGE_KEY, message);
        } else {
            editTextMessage.setError(getString(R.string.error_missing_message));
        }
        startActivityForResult(secondActivity, REQUEST_CODE_MESSAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE_MESSAGE && resultCode == RESULT_OK) {
            String result = data.getStringExtra(MESSAGE_KEY);
            Logging.show(TAG, result);
        }
    }

    public void buttonOpenFormActivityOnClick(View view) {
        Intent formActivity = new Intent(MainActivity.this, FormActivity.class);
        startActivity(formActivity);
    }

    public void buttonOpenSumActivityOnClick(View view) {
        Intent formActivity = new Intent(MainActivity.this, SumActivity.class);
        startActivity(formActivity);
    }

    public void buttonOpenNavigationDrawerActivityOnClick(View view) {
        Intent formActivity = new Intent(MainActivity.this, NavigationActivity.class);
        startActivity(formActivity);
    }

    public void buttonOpenStyleActivityOnClick(View view) {
        Intent formActivity = new Intent(MainActivity.this, StyleSamplesActivity.class);
        startActivity(formActivity);
    }
}
