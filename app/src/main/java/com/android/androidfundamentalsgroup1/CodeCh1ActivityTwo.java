package com.android.androidfundamentalsgroup1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CodeCh1ActivityTwo extends AppCompatActivity {
    private final String TAG = "Second Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Logging.show(TAG, "on Start");
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