package com.android.androidfundamentalsgroup1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private final String TAG = "SecondActivity";
    private TextView textViewTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        onInitViews();

        Logging.show(TAG, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Logging.show(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Logging.show(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Logging.show(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Logging.show(TAG, "onStop");
    }

    private void onInitViews() {
        textViewTop = findViewById(R.id.textViewTop);
    }

    public void buttonLeftOnClick(View view) {
        textViewTop.setText("clicked left button");

        // implicit intent for action dial
        Intent implicitIntentCaller = new Intent(Intent.ACTION_DIAL);
        implicitIntentCaller.setData(Uri.parse("tel:0744444444"));
        if (implicitIntentCaller.resolveActivity(getPackageManager()) != null) {
            startActivity(implicitIntentCaller);
        }
    }

    public void buttonRightOnClick(View view) {
        textViewTop.setText("clicked left button");
    }
}