package com.android.androidfundamentalsgroup1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CodeCh1ActivityOne extends AppCompatActivity {
    TextView firstActivityTextView;
    Button secondActivityButton;
    private final String TAG = "First Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        secondActivityButton = findViewById(R.id.secondActivityButton);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Logging.show(TAG, "on Start");
        secondActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CodeCh1ActivityOne.this, CodeCh1ActivityTwo.class);
            startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Logging.show(TAG, "on Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Logging.show(TAG, "on Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Logging.show(TAG, "on Stop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Logging.show(TAG, "on Restart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logging.show(TAG, "on Destroy");
    }

}