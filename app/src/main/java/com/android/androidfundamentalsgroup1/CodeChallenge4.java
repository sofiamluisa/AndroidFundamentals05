package com.android.androidfundamentalsgroup1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CodeChallenge4 extends AppCompatActivity {
    private TextView editTextWebSite;
    private TextView editTextOpenLocation;
    private TextView editTextShare;
    private TextView editTextPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_challenge4);
        editTextWebSite = findViewById(R.id.editTextWebSite);
        editTextOpenLocation = findViewById(R.id.editTextOpenLocation);
        editTextShare = findViewById(R.id.editTextShare);
        editTextPhone = findViewById(R.id.editTextPhone);
    }

    public void buttonOpenWebsiteOnClick(View view) {
        Intent implicitIntentOpenWebSite = new Intent(Intent.ACTION_VIEW);
        String contentFromEditTextOpenWebSite = editTextWebSite.getText().toString();
        implicitIntentOpenWebSite.setData(Uri.parse(contentFromEditTextOpenWebSite));
        if (implicitIntentOpenWebSite.resolveActivity(getPackageManager()) != null) {
            startActivity(implicitIntentOpenWebSite);
        }
    }

    public void buttonOpenLocationOnClick(View view) {
        Intent implicitIntentOpenLocation = new Intent(Intent.ACTION_VIEW);
        String contentFromEditTextOpenLocation = editTextOpenLocation.getText().toString();
        implicitIntentOpenLocation.setData(Uri.parse("geo:0,0?q=" + contentFromEditTextOpenLocation));
        if (implicitIntentOpenLocation.resolveActivity(getPackageManager()) != null) {
            startActivity(implicitIntentOpenLocation);
        }
    }

    public void buttonShareTextOnClick(View view) {
        Intent implicitIntentShareText = new Intent(Intent.ACTION_SEND);
        String contentFromEditTextShareText = editTextShare.getText().toString();
        implicitIntentShareText.putExtra(Intent.EXTRA_TEXT, contentFromEditTextShareText);
        implicitIntentShareText.setType("text/plain");
        if (implicitIntentShareText.resolveActivity(getPackageManager()) != null) {
            startActivity(implicitIntentShareText);
        }
    }

    public void buttonPhoneCallOnClick(View view) {
        Intent implicitIntentCaller = new Intent(Intent.ACTION_DIAL);
        String contentFromEditTextPhoneCall = editTextPhone.getText().toString();
        implicitIntentCaller.setData(Uri.parse("tel:" + contentFromEditTextPhoneCall));
        if (implicitIntentCaller.resolveActivity(getPackageManager()) != null) {
            startActivity(implicitIntentCaller);
        }
    }
}