package com.example.a20190330;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class TenActivity extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ten);
        webView = findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setGeolocationEnabled(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBlockNetworkImage(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setAllowFileAccess(true);
        webSettings.setTextZoom(100);
        webSettings.setAllowContentAccess(true);
        webSettings.setAllowFileAccessFromFileURLs(true);
        webSettings.setAllowUniversalAccessFromFileURLs(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setAppCacheEnabled(true);
//        String webViewCachePath = FwConstants.getWebViewCachePath(CCConstant.APPLICATION);
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
//        webSettings.setAppCachePath(webViewCachePath);
        webSettings.setAppCacheMaxSize(8388608L);
        webSettings.setDatabaseEnabled(true);
//        webSettings.setGeolocationDatabasePath(webViewCachePath);
        //自动播放背景音乐
        webSettings.setMediaPlaybackRequiresUserGesture(false);
        webView.loadUrl("file:///android_asset/picture.html");
        webView.setWebViewClient(new WebViewClient(){

        });
    }
}
