package com.nytimes.demo.nytimes.news;


import com.nytimes.demo.nytimes.activeandroidPojo.ResultPojo;
import com.nytimes.demo.nytimes.news.models.NewsResponse;

import java.util.List;

public interface NewsView {
    void showWait();

    void removeWait();

    void onFailure(String appErrorMessage);

    void geNewsListSuccess(NewsResponse newsResponse);

    void initialiseAdapter(List<ResultPojo> resultPojos);

    void setActivityActionBarTitle(String s);
}