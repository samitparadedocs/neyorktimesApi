package com.nytimes.demo.nytimes.news;


import com.nytimes.demo.nytimes.news.models.NewsResponse;

public interface NewsView {
    void showWait();

    void removeWait();

    void onFailure(String appErrorMessage);

    void geNewsListSuccess(NewsResponse newsResponse);

}