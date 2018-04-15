package com.nytimes.demo.nytimes.networking;
import com.nytimes.demo.nytimes.news.models.NewsResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
public interface NetworkService {
/*    @GET("https://api.nytimes.com/svc/topstories/v2/home.json?api-key=278ce66aae5c4da38b3bb46cf0b82bbc")
    Observable<JsonObject> getNewsList();*/
    @GET("https://api.nytimes.com/svc/topstories/v2/home.json?")
    Observable<NewsResponse> getNewsList(@Query("api-key") String apiKey);
}