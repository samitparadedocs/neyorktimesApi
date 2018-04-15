package com.nytimes.demo.nytimes.news;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.nytimes.demo.nytimes.BaseActivity;
import com.nytimes.demo.nytimes.R;
import com.nytimes.demo.nytimes.activeandroidPojo.ResultPojo;
import com.nytimes.demo.nytimes.databinding.ActivityMainBinding;
import com.nytimes.demo.nytimes.networking.Service;
import com.nytimes.demo.nytimes.news.models.NewsResponse;
import com.nytimes.demo.nytimes.newsdetail.NewsDetailActivity;

import java.util.List;

import javax.inject.Inject;
/*
With the help of the News Actvity We can load the newslist consuming apis for
Neyork times.
 */
public class NewsActivity extends BaseActivity implements NewsView {

    @Inject
    public Service service;
    public NewsPresenter presenter;
    private ActivityMainBinding mBinding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDeps().inject(this);
        renderView();
        init();
        presenter = new NewsPresenter(service, this);
        presenter.getNewsList();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void renderView() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    public void init() {
        mBinding.list.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void setActivityActionBarTitle(String activityActionBarTitle) {
        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(activityActionBarTitle);
    }
    @Override
    public void showWait() {
        mBinding.progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void removeWait() {
        mBinding.progress.setVisibility(View.GONE);
    }

    @Override
    public void onFailure(String appErrorMessage) {
        Toast.makeText(this, appErrorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void geNewsListSuccess(NewsResponse newsResponse) {
       // success
    }

    /**
     * @param resultPojo
     * Below method useful to intialize Adapter and set list received after
     * response
     */
    @Override
    public void initialiseAdapter(List<ResultPojo> resultPojo) {
        NewsAdapter adapter = new NewsAdapter(getApplicationContext(), resultPojo,
                new NewsAdapter.OnItemClickListener() {
                    @Override
                    public void onClick(ResultPojo item) {
                        Toast.makeText(getApplicationContext(), item.getTitle(),
                                Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(NewsActivity.this, NewsDetailActivity.class);
                        intent.putExtra("newsObj", item);
                        startActivity(intent);
                    }
                });
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mBinding.list.getContext(),
                LinearLayoutManager.VERTICAL);
        mBinding.list.addItemDecoration(dividerItemDecoration);
        mBinding.list.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);//Menu Resource, Menu
        return true;
    }

    /**
     * @param item menu item
     * @return
     * With the help of the onOptionsItemSelected
     * WE can get the result for the different category
     * for now i have provise support only for TOp STORIES
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                presenter.getNewsList();
                Toast.makeText(getApplicationContext(), "Top Stories Seleted", Toast.LENGTH_LONG).show();
                return true;
            case R.id.item2:
                Toast.makeText(getApplicationContext(), "Coming soon", Toast.LENGTH_LONG).show();
                return true;
            case R.id.item3:
                Toast.makeText(getApplicationContext(), "Coming soon", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}