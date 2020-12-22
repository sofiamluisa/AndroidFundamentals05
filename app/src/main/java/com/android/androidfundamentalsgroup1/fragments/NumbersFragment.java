package com.android.androidfundamentalsgroup1.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.android.androidfundamentalsgroup1.Logging;
import com.android.androidfundamentalsgroup1.R;

public class NumbersFragment extends Fragment implements View.OnClickListener {

    private EditText editTextFirstNumber, editTextSecondNumber;
    private Button buttonSendNumbersToActivity;

    public NumbersFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_numbers, container, false);
        editTextFirstNumber = view.findViewById(R.id.editTextFirstNumberFromFragment);
        editTextSecondNumber = view.findViewById(R.id.editTextSecondNumberFromFragment);
        buttonSendNumbersToActivity = view.findViewById(R.id.buttonSendNumbersToActivityOnClick);
        buttonSendNumbersToActivity.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        if(view == buttonSendNumbersToActivity) {
            int firstNumber = getNumber(editTextFirstNumber);
            int secondNumber = getNumber(editTextSecondNumber);

            SumListener sumListener = (SumListener) getActivity();
            sumListener.addTwoNumbers(firstNumber, secondNumber);
        }
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
}