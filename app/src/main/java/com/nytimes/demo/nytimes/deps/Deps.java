package com.nytimes.demo.nytimes.deps;

import com.nytimes.demo.nytimes.news.NewsActivity;
import com.nytimes.demo.nytimes.networking.NetworkModule;
import com.nytimes.demo.nytimes.newsdetail.NewsDetailActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class,})
public interface Deps {
    void inject(NewsActivity newsActivity);
    void inject(NewsDetailActivity newsDetailActivity);
}