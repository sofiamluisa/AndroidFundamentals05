package com.android.androidfundamentalsgroup1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class CodeCh2ActivityTwo extends AppCompatActivity {
    private final String TAG = "Activity Two";
    TextView textViewContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_ch2_two);

        Bundle text = getIntent().getExtras();
        if(text != null)
        {
            String textLyrics = text.getString(CodeCh2ActivityOne.KEY_MESSAGE);
            textViewContent = findViewById(R.id.textViewCodeCh2);
            textViewContent.setText(textLyrics);

        }

    }
    }
