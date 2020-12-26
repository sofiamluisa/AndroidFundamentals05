package com.android.androidfundamentalsgroup1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CodeChallange3SecondActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MESSAGE = 12;
    public static final String MESSAGE_KEY = "message";
    TextView upperTextViewCodech3_2;
    TextView bottomTextViewCodech3_2;
    EditText editTextMessage3_2;
    Button buttonSend3_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_challange3_second);

        upperTextViewCodech3_2 = findViewById(R.id.upperTextViewCodech3_2);
        bottomTextViewCodech3_2 = findViewById(R.id.bottomTextViewCodech3_2);
        editTextMessage3_2 = findViewById(R.id.editTextMessage3_2);
        buttonSend3_2 = findViewById(R.id.buttonSend3_2);
        Intent intent = getIntent();
        String messageReceived = intent.getStringExtra(CodeChallange3FirstActivity.MESSAGE_KEY);

        upperTextViewCodech3_2.setText(messageReceived);
        buttonSend3_2.setOnClickListener(v -> {
            Intent returnIntent = new Intent();
            String message = editTextMessage3_2.getText().toString();
            upperTextViewCodech3_2.setText(R.string.message_received);
            returnIntent.putExtra(CodeChallange3FirstActivity.MESSAGE_KEY, message);
            setResult(Activity.RESULT_OK, returnIntent);
            finish();
            Toast.makeText(this, "You are in the first activity", Toast.LENGTH_SHORT).show();
        });

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            String message = bundle.getString(CodeChallange3FirstActivity.MESSAGE_KEY);
            upperTextViewCodech3_2.setText(R.string.message_received);
            bottomTextViewCodech3_2.setText(message);
        }
    }

    public void buttonSendMessage2OnClick(View view) {
        Intent intent = new Intent(CodeChallange3SecondActivity.this, CodeChallange3FirstActivity.class);
        String message = editTextMessage3_2.getText().toString();
        if (message != null && message.length() > 0) {
            intent.putExtra(CodeChallange3FirstActivity.MESSAGE_KEY, message);
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
