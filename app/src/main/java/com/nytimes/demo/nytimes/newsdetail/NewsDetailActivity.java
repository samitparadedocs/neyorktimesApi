package com.nytimes.demo.nytimes.newsdetail;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.nytimes.demo.nytimes.BaseActivity;
import com.nytimes.demo.nytimes.R;
import com.nytimes.demo.nytimes.activeandroidPojo.MultimediumPojo;
import com.nytimes.demo.nytimes.activeandroidPojo.ResultPojo;
import com.nytimes.demo.nytimes.databinding.ActivityDetailfinalBinding;
import com.nytimes.demo.nytimes.networking.Service;
import com.nytimes.demo.nytimes.utils.Utils;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by Samit
 * on 4/14/2018.
 */

public class NewsDetailActivity extends BaseActivity implements DetailView {
    private ActivityDetailfinalBinding activityDetailBinding;
    private ResultPojo newsResult;
    private int count = 0;
    private ArrayList<String> ImagesArray = new ArrayList<>();

    @Inject
    public Service service;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDeps().inject(this);
        activityDetailBinding = DataBindingUtil.setContentView(NewsDetailActivity.this, R.layout.activity_detailfinal);
        Intent intent;

        if (getIntent() != null) {
            intent = getIntent();
            newsResult = (ResultPojo) intent.getSerializableExtra("newsObj");
        }
        renderView();
    }

    private void renderView() {
        for (MultimediumPojo multimedium : newsResult.getMultimedia())
            ImagesArray.add(multimedium.getUrl());

        activityDetailBinding.txtTitle.setText(newsResult.getTitle());
        activityDetailBinding.txtDesc.setText(newsResult.get_abstract());

        activityDetailBinding.pager.setAdapter(new SlidingImageAdapter(NewsDetailActivity.this, ImagesArray));

        activityDetailBinding.webView.loadUrl(newsResult.getUrl());
        activityDetailBinding.webView.setWebViewClient(new HelloWebViewClient());
        activityDetailBinding.webView.getSettings().setJavaScriptEnabled(true);
        if (Utils.isNetworkAvailable(this)) {
            activityDetailBinding.webView.loadUrl(newsResult.getUrl());
        }else {
            activityDetailBinding.webView.setVisibility(View.INVISIBLE);
        }
    }

    class HelloWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
