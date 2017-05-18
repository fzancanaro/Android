package com.vivianaranha.webapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());

        editText = (EditText) findViewById(R.id.editText);
//        webView.loadUrl("http://www.google.com");
    }

    public void backButton(View view) {
        if(webView.canGoBack()) {
            webView.goBack();
        }
    }

    public void fwdButton(View view) {
        if(webView.canGoForward()) {
            webView.goForward();
        }
    }

    public void reloadButton(View view) {
        webView.reload();
    }

    public void goButton(View view) {

        String url = editText.getText().toString();
        webView.loadUrl(url);
    }
}
