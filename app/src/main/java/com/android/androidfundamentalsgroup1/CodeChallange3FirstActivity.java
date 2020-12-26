package com.android.androidfundamentalsgroup1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CodeChallange3FirstActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MESSAGE = 12;
    public static final String MESSAGE_KEY = "message";
    private TextView upperTextViewCodech3_1;
    private TextView bottomTextViewCodech3_1;
    private EditText editTextMessage3_1;

    private Button buttonSend3_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_challange3_first);
        upperTextViewCodech3_1 = findViewById(R.id.upperTextViewCodech3_1);
        bottomTextViewCodech3_1 = findViewById(R.id.bottomTextViewCodech3_1);
        editTextMessage3_1 = findViewById(R.id.editTextMessage3_1);
        buttonSend3_1 = findViewById(R.id.buttonSend3_1);
        buttonSend3_1.setOnClickListener(v -> {
            Intent intent = new Intent(CodeChallange3FirstActivity.this, CodeChallange3SecondActivity.class);
            String message = editTextMessage3_1.getText().toString();
            intent.putExtra(MESSAGE_KEY, message);
            startActivityForResult(intent, REQUEST_CODE_MESSAGE);
            Toast.makeText(this, "You are in the second activity", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_MESSAGE && resultCode == RESULT_OK) {
            String result = data.getStringExtra(MESSAGE_KEY);
            upperTextViewCodech3_1.setText(R.string.reply_received);
            bottomTextViewCodech3_1.setText(result);
        }
    }
}
