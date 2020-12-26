package com.android.androidfundamentalsgroup1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CodeCh2ActivityOne extends AppCompatActivity {
    public static final String KEY_MESSAGE = "message";
    private Button buttonTextViewOne;
    private Button buttonTextViewTwo;
    private Button buttonTextViewThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_ch2_one);
        buttonTextViewOne = findViewById(R.id.buttonTextOne);
        buttonTextViewTwo = findViewById(R.id.buttonTextTwo);
        buttonTextViewThree = findViewById(R.id.buttonTextThree);

        buttonTextViewOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String textOne = getString(R.string.button_text_one);
                Intent intent = new Intent(CodeCh2ActivityOne.this, CodeCh2ActivityTwo.class);
                intent.putExtra(KEY_MESSAGE, textOne);
                startActivity(intent);
            }
        });

        buttonTextViewTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String textTwo = getString(R.string.button_text_two);
                Intent intent = new Intent(CodeCh2ActivityOne.this, CodeCh2ActivityTwo.class);
                intent.putExtra(KEY_MESSAGE, textTwo);
                startActivity(intent);
            }
        });

        buttonTextViewThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String textThree = getString(R.string.button_text_three);
                Intent intent = new Intent(CodeCh2ActivityOne.this, CodeCh2ActivityTwo.class);
                intent.putExtra(KEY_MESSAGE, textThree);
                startActivity(intent);
            }
        });
    }

}