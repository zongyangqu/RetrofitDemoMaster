package com.example.administrator.retrofitdemo.ui;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.administrator.retrofitdemo.R;
import com.example.administrator.retrofitdemo.base.BaseActivity;

/**
 * 类名称：
 * 类描述：
 * 创建人：quzongyang
 * 创建时间：2016/7/29. 18:16
 * 版本：
 */
public class NewsDetailActivity extends BaseActivity {

    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        webview = (WebView) findViewById(R.id.webview);
        String webURL = getIntent().getStringExtra("WEBURL");
        webview.loadUrl(webURL);
    }
}
