package com.android.androidfundamentalsgroup1.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.androidfundamentalsgroup1.Logging;
import com.android.androidfundamentalsgroup1.R;

public class SumActivity extends AppCompatActivity implements SumListener {
    public static final String FIRST_NUMBER = "firstNumber";
    public static final String SECOND_NUMBER = "secondNumber";

    private EditText editTextFirstNumber, editTextSecondNumber;
    private TextView textViewSum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum);

        editTextFirstNumber = findViewById(R.id.editTextFirstNumber);
        editTextSecondNumber = findViewById(R.id.editTextSecondNumber);
        textViewSum = findViewById(R.id.textViewSumResultFromFragmentValues);

        displayFragment(new NumbersFragment());
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

    // method option with setter in Fragment
    public void buttonSendNumbersToFragmentWithSetterOnClick(View view) {
        int firstNumber = getNumber(editTextFirstNumber);
        int secondNumber = getNumber(editTextSecondNumber);

        SumResultFragment sumResultFragment = new SumResultFragment();
        sumResultFragment.setNumbers(firstNumber, secondNumber);
        displayFragment(sumResultFragment);
    }

    @Override
    public void addTwoNumbers(int a, int b) {
        int sum = a + b;
        textViewSum.setText(getString(R.string.result_sum_from_fragment) + sum);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(SumActivity.this, R.string.back_button_pressed, Toast.LENGTH_LONG).show();
    }
}