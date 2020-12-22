package com.android.androidfundamentalsgroup1.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.androidfundamentalsgroup1.R;

public class SumResultFragment extends Fragment {
    private TextView textViewResult;

    private int firstNumber, secondNumber;

    public SumResultFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            firstNumber = getArguments().getInt(SumActivity.FIRST_NUMBER);
            secondNumber = getArguments().getInt(SumActivity.SECOND_NUMBER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sum_result, container, false);

        textViewResult = view.findViewById(R.id.textViewSumOfNumbersFromActivity);
        int sum = firstNumber + secondNumber;
        textViewResult.setText(getString(R.string.sum_result) + sum);

        return view;
    }

    public void setNumbers(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }
}