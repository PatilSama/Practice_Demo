package com.example.practice_demo;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WebView_Activity extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_layout);
        webView = findViewById(R.id.webView);
        webView.loadUrl("https://abhiandroid.com/ui/autocompletetextview");
        WebSettings webSettings = webView.getSettings();
        webSettings.getJavaScriptEnabled();
    }
}
