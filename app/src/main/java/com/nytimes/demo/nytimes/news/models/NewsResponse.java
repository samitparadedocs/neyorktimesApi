package com.nytimes.demo.nytimes.news.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class NewsResponse implements Serializable{

@SerializedName("status")
@Expose
private String status;
@SerializedName("copyright")
@Expose
private String copyright;
@SerializedName("num_results")
@Expose
private int numResults;
@SerializedName("results")
@Expose
private List<Result> results = null;

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

public String getCopyright() {
return copyright;
}

public void setCopyright(String copyright) {
this.copyright = copyright;
}

public int getNumResults() {
return numResults;
}

public void setNumResults(int numResults) {
this.numResults = numResults;
}

public List<Result> getResults() {
return results;
}

public void setResults(List<Result> results) {
this.results = results;
}

    @Override
    public String toString() {
        return "NewsResponse{" +
                "status='" + status + '\'' +
                ", copyright='" + copyright + '\'' +
                ", numResults=" + numResults +
                ", results=" + results +
                '}';
    }
}