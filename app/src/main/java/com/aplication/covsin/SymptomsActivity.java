package com.aplication.covsin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SymptomsActivity extends AppCompatActivity {

    private WebView symWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms);

        symWeb = findViewById(R.id.webSymptoms);
        symWeb.getSettings().setJavaScriptEnabled(true);
        symWeb.setWebViewClient(new WebViewClient());
        symWeb.loadUrl("https://espanol.cdc.gov/coronavirus/2019-ncov/symptoms-testing/symptoms.html");

    }



}