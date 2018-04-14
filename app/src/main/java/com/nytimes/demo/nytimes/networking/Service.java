package com.nytimes.demo.nytimes.networking;

import android.util.Log;


import com.nytimes.demo.nytimes.news.models.NewsResponse;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class Service {
    private final NetworkService networkService;

    public Service(NetworkService networkService) {
        this.networkService = networkService;
    }

    public Subscription getNewsList(final GetNewsListCallback getNewsListCallback){
        return networkService.getNewsList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

                .onErrorResumeNext(new Func1<Throwable, Observable<? extends NewsResponse>>() {
                    @Override
                    public Observable<? extends NewsResponse> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                 .subscribe(new Subscriber<NewsResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                getNewsListCallback.onError(new NetworkError(e));

            }

            @Override
            public void onNext(NewsResponse newsResponse) {
               Log.d("samit test",""+newsResponse);
                getNewsListCallback.onSuccess(newsResponse);
              try {
               //   NewsResponse newsResponse1= new Gson().fromJson(newsResponse,NewsResponse.class);
                  Log.d("news final response",newsResponse.toString() );
              }catch (Exception e){
                  e.printStackTrace();
              }

            }
        });
    };

    public interface GetNewsListCallback{
        void onSuccess(NewsResponse newsResponse);
        void onError(NetworkError networkError);
    }
}