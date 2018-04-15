package com.nytimes.demo.nytimes.newsdetail;

import com.nytimes.demo.nytimes.networking.Service;
import com.nytimes.demo.nytimes.news.NewsView;
import com.nytimes.demo.nytimes.news.models.Result;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by Samit on
 * 4/14/2018.
 */

public class NewsDetailPresenter {
    private final Service service;
    private final DetailView view;
    private CompositeSubscription subscriptions;
    private Result result;
    public NewsDetailPresenter(Service service, DetailView view,Result result) {
        this.service = service;
        this.view = view;
        this.subscriptions = new CompositeSubscription();
        this.result=result;
    }
}
