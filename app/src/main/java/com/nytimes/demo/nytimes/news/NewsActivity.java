package com.nytimes.demo.nytimes.news;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.nytimes.demo.nytimes.BaseActivity;
import com.nytimes.demo.nytimes.R;
import com.nytimes.demo.nytimes.activeandroid.Details;
import com.nytimes.demo.nytimes.databinding.ActivityMainBinding;
import com.nytimes.demo.nytimes.networking.Service;
import com.nytimes.demo.nytimes.news.models.NewsResponse;
import com.nytimes.demo.nytimes.news.models.Result;
import com.nytimes.demo.nytimes.newsdetail.NewsDetailActivity;


import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

public class NewsActivity extends BaseActivity implements NewsView {

    @Inject
    public  Service service;
    long id;
    Details details= new Details();
    private ActivityMainBinding mBinding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDeps().inject(this);

        renderView();
        init();

        NewsPresenter presenter = new NewsPresenter(service, this);
        presenter.getNewsList();


      /* details.name="Samit p";
       details.age="21";
       insertData(details);*/
    }

    public  void renderView(){
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

      //  list = (RecyclerView) findViewById(R.id.list);
        //progressBar = (ProgressBar) findViewById(R.id.progress);
    }

    public void init(){
        mBinding.list.setLayoutManager(new LinearLayoutManager(this));
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

    }

    @Override
    public void geNewsListSuccess(NewsResponse newsResponse) {
        NewsAdapter adapter = new NewsAdapter(getApplicationContext(), newsResponse.getResults(),
                new NewsAdapter.OnItemClickListener() {
                    @Override
                    public void onClick(Result item) {
                        Toast.makeText(getApplicationContext(), item.getTitle(),
                                Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(NewsActivity.this,NewsDetailActivity.class);
                        intent.putExtra("newsObj",  item);
                        startActivity(intent);
                    }
                });

        mBinding.list.setAdapter(adapter);
        //notify data to list

      /* Result result= newsResponse.getResults().get(0);
        ResultPojo resultPojo=new ResultPojo();
        resultPojo.setData(result);
      long id= resultPojo.save();
        Log.v("id_value", String.valueOf(id));
        recreate();*/

    }

    public void insertData(Details details){
        id = details.save();
        Log.v("id_value", String.valueOf(id));
        recreate();
    }

    // Read all Data
    private List<Details> getAll() {
        return new Select()
                .from(Details.class)
                .orderBy("id ASC")
                .execute();
    }

    // Read Particular Data
    private Details getOne(String id) {
        return new Select()
                .from(Details.class)
                .where("id = ?", id)
                .executeSingle();
    }

    // Delete All
    private void deleteAll() {
        new Delete().from(Details.class).execute();
    }

    // Delete Particular Data
    private void deleteOne(long id) {
        Details.delete(Details.class , id);
    }

    // Update Data
    public void updateData(Details details){
        id = details.save();
        Log.v("updated_id_value", String.valueOf(id));
        recreate();
    }
}