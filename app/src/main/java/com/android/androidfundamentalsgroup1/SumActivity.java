package com.android.androidfundamentalsgroup1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;

public class SumActivity extends AppCompatActivity {
    public static final String FIRST_NUMBER = "firstNumber";
    public static final String SECOND_NUMBER = "secondNumber";

    private EditText editTextFirstNumber, editTextSecondNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum);

        editTextFirstNumber = findViewById(R.id.editTextFirstNumber);
        editTextSecondNumber = findViewById(R.id.editTextSecondNumber);
    }

    // bundle option with setArguments and getArguments
    public void buttonSendNumbersToFragmentOnClick(View view) {
        Bundle bundleForSendingDataToFragment = getBundle();

        SumResultFragment sumResultFragment = new SumResultFragment();
        sumResultFragment.setArguments(bundleForSendingDataToFragment);
        displayFragment(sumResultFragment);
    }

    private Bundle getBundle() {
        int firstNumber = getNumber(editTextFirstNumber);
        int secondNumber = getNumber(editTextSecondNumber);

        Bundle bundleForSendingDataToFragment = new Bundle();
        bundleForSendingDataToFragment.putInt(FIRST_NUMBER, firstNumber);
        bundleForSendingDataToFragment.putInt(SECOND_NUMBER, secondNumber);
        return bundleForSendingDataToFragment;
    }

    private int getNumber(EditText editTextNumber) {
        String value = editTextNumber.getText().toString();
        if (value.length() > 0) {
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException numberFormatException) {
                editTextNumber.setError(getString(R.string.error_not_a_number));
                Logging.show("error", numberFormatException.getMessage());
                return 0;
            }
        } else {
            return 0;
        }
    }

    private void displayFragment(Fragment newFragment) {
        try {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.placeholder, newFragment);
            fragmentTransaction.commit();
        } catch (NullPointerException nullPointerException) {
            Logging.show("null", nullPointerException.getMessage());
        }
    }
}