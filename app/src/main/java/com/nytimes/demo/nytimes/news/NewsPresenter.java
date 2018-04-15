package com.nytimes.demo.nytimes.news;

import android.util.Log;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Delete;
import com.nytimes.demo.nytimes.activeandroidPojo.MultimediumPojo;
import com.nytimes.demo.nytimes.activeandroidPojo.ResultPojo;
import com.nytimes.demo.nytimes.networking.NetworkError;
import com.nytimes.demo.nytimes.networking.Service;
import com.nytimes.demo.nytimes.news.models.NewsResponse;
import com.nytimes.demo.nytimes.news.models.Result;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * With help of news presenter we can separate out the logic for the
 */
public class NewsPresenter {
    private final Service service;
    private final NewsView view;
    private CompositeSubscription subscriptions;

    public NewsPresenter(Service service, NewsView view) {
        this.service = service;
        this.view = view;
        this.subscriptions = new CompositeSubscription();
    }
    /**
     * Get News list for TOP STORIES APIS.
     */
    public void getNewsList() {
        view.showWait();

        Subscription subscription = service.getNewsList(new Service.GetNewsListCallback() {
            @Override
            public void onSuccess(NewsResponse newsResponse) {
                view.removeWait();
                processNewsResponse(newsResponse);

            }
            @Override
            public void onError(NetworkError networkError) {
                view.removeWait();
                loadDataFromLocalDatabase(networkError);
            }
        });

        subscriptions.add(subscription);
    }

    private void loadDataFromLocalDatabase(NetworkError networkError) {

        List<ResultPojo> list = ResultPojo.getResultMultiMediaMapping();
        view.initialiseAdapter(list);
        view.onFailure(networkError.getAppErrorMessage());

    }

   /* private void processNewsResponse(NewsResponse newsResponse) {
        view.geNewsListSuccess(newsResponse);
    }*/

   /**
     * @param newsResponse
     * this method useful to process response for
     * https://api.nytimes.com/svc/topstories/v2/home.json.
     * in this method we can save response into Local databse using Active
     * Android.
     */
    private void processNewsResponse(NewsResponse newsResponse) {
        ActiveAndroid.beginTransaction();
        List<ResultPojo> resultPojos = new ArrayList<>();
        try {
            //notify data to list
            if (newsResponse.getResults().size() > 0) {
                new Delete().from(ResultPojo.class).execute();
                new Delete().from(MultimediumPojo.class).execute();
            }


            for (Result result : newsResponse.getResults()) {
                ResultPojo resultPojo = new ResultPojo();
                resultPojo.setData(result);
                long id = resultPojo.save();
                Log.v("id_value main table", String.valueOf(id));
                for (MultimediumPojo multimediumPojo : resultPojo.multimedia) {
                    multimediumPojo.setMappingId(id);
                    long idLong = multimediumPojo.save();
                    Log.v("id_value mapping table", String.valueOf(idLong));
                }
                resultPojos.add(resultPojo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ActiveAndroid.setTransactionSuccessful();
        }
        view.initialiseAdapter(resultPojos);
        view.setActivityActionBarTitle("Top Stories");
        view.geNewsListSuccess(newsResponse);
    }

    public void onStop() {
        subscriptions.unsubscribe();
    }}