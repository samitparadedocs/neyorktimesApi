package com.nytimes.demo.nytimes.news;

import com.nytimes.demo.nytimes.networking.NetworkError;
import com.nytimes.demo.nytimes.networking.Service;
import com.nytimes.demo.nytimes.news.models.NewsResponse;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class NewsPresenter {
    private final Service service;
    private final NewsView view;
    private CompositeSubscription subscriptions;

    public NewsPresenter(Service service, NewsView view) {
        this.service = service;
        this.view = view;
        this.subscriptions = new CompositeSubscription();
    }


    public void onStop() {
        subscriptions.unsubscribe();
    }


    public void getNewsList(){
        view.showWait();

        Subscription subscription = service.getNewsList(new Service.GetNewsListCallback() {
            @Override
            public void onSuccess(NewsResponse newsResponse) {
                view.removeWait();
                view.geNewsListSuccess(newsResponse);
            }

            @Override
            public void onError(NetworkError networkError) {
                view.removeWait();
                view.onFailure(networkError.getAppErrorMessage());
            }

        });

        subscriptions.add(subscription);
    }
}