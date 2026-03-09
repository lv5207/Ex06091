package com.example.ex06091;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
private WebView wV;
private EditText etUrl;
private Button btnGo;
private String stringUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wV = findViewById(R.id.wV);
        etUrl = findViewById(R.id.etUrl);
        btnGo = findViewById(R.id.btnGo);

        wV.getSettings().setJavaScriptEnabled(true);
    }

    public void goToUrl(View view) {
        stringUrl = etUrl.getText().toString();
        wV.loadUrl(stringUrl);
        wV.setWebViewClient(new MyWebViewClient());
    }

    private class MyWebViewClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url)
        {
            view.loadUrl(url);
            return true;
        }
    }
}