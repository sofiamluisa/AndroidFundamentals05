package com.android.androidfundamentalsgroup1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // CTRL/CMD + B = go to definition
        // CTRL + Q = show documentation
        // CTRL + P = show the params of a method
        // CTRL + ALT + L = format the code
        // TODO finish the implementation

        int countStudents = 28;
        if (countStudents % 2 == 0) {
            countStudents++;
            Log.e("MainActivity", "numar par"); // afisat cu rosu, log pentru eroare
            Log.d("MainActivity", countStudents + ""); // afisat cu gri, log pentru debug
        } else if (countStudents % 3 == 0) {
            Log.i("MainActivity", "numar divizibil cu 3");
        }
    }
}
