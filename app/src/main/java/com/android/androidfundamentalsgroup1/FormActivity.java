package com.android.androidfundamentalsgroup1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;

public class FormActivity extends AppCompatActivity {
    private static final String VALUE_SCORE = "score";
    private static final String FORM_ACTIVITY = "FormActivity";

    private EditText editTextPersonName;
    private CheckBox checkBoxIAccept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        editTextPersonName = findViewById(R.id.editTextPersonName);
        checkBoxIAccept = findViewById(R.id.checkBoxIAccept);

        addDynamicallyNewFragment(new BlankFragment());
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(VALUE_SCORE, 23);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Logging.show(FORM_ACTIVITY, savedInstanceState.getInt(VALUE_SCORE) + "");
    }

    private void addDynamicallyNewFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.thePlaceholder, fragment);
        fragmentTransaction.commit();
    }
}