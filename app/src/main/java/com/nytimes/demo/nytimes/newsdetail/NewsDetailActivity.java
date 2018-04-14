package com.nytimes.demo.nytimes.newsdetail;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.nytimes.demo.nytimes.BaseActivity;
import com.nytimes.demo.nytimes.R;
import com.nytimes.demo.nytimes.databinding.ActivityDetailfinalBinding;
import com.nytimes.demo.nytimes.networking.Service;
import com.nytimes.demo.nytimes.news.models.Result;

import javax.inject.Inject;

/**
 * Created by Samit on 4/14/2018.
 */

public class NewsDetailActivity extends BaseActivity implements DetailView{
    private ActivityDetailfinalBinding activityDetailBinding;
    private Result newsResult;

    @Inject
    public Service service;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDeps().inject(this);
        activityDetailBinding = DataBindingUtil.setContentView(NewsDetailActivity.this, R.layout.activity_detailfinal);
        Intent intent;

        if(getIntent()!=null){
            intent=getIntent();
           newsResult = (Result) intent.getSerializableExtra("newsObj");
        }
        renderView();

        //NewsDetailPresenter presenter = new NewsDetailPresenter(service, this,newsResult);


    }

    private void renderView() {

       activityDetailBinding.setResultVal(newsResult);
    }
}
