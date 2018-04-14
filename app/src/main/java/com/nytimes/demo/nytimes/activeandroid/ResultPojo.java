package com.nytimes.demo.nytimes.activeandroid;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.nytimes.demo.nytimes.news.models.Multimedium;
import com.nytimes.demo.nytimes.news.models.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Samit on 4/13/2018.
 */
@Table(name = "Results")
public class ResultPojo extends Model {
    @Column
    private String subsection;
    @Column
    private String title;
    @Column
    private String _abstract;
    @Column
    private String url;
    @Column
    private String byline;
    @Column
    private String thumbnailStandard;
    @Column
    private String itemType;
    @Column
    private String source;
    @Column
    private String updatedDate;
    @Column
    private String createdDate;
    @Column
    private String publishedDate;
    @Column
    private String firstPublishedDate;
    @Column
    private String materialTypeFacet;
    @Column
    private String kicker;
    @Column
    private String subheadline;
    @Column
    private List<String> desFacet = null;
    @Column
    private List<String> orgFacet = null;
    @Column
    private List<String> perFacet = null;
    @Column
    private List<String> geoFacet;
    @Column
    private String relatedUrls;
    public List<MultimediumPojo> multimedia = new ArrayList<>();

    public void setData(Result result) {
        subsection = result.subsection;
        title = result.title;
        _abstract = result._abstract;
        url = result.url;
        byline = result.byline;
        thumbnailStandard = result.thumbnailStandard;
        itemType = result.itemType;
        source = result.source;
        updatedDate = result.updatedDate;
        createdDate = result.createdDate;
        publishedDate = result.publishedDate;
        firstPublishedDate = result.firstPublishedDate;
        materialTypeFacet = result.materialTypeFacet;
        kicker = result.kicker;
        subheadline = result.subheadline;

        desFacet = result.desFacet;
        orgFacet = result.orgFacet;
        perFacet = result.orgFacet;
        geoFacet = result.geoFacet;
        relatedUrls = result.relatedUrls;

        for (Multimedium multimedium : result.multimedia) {
            MultimediumPojo multimediumPojo = new MultimediumPojo();
            multimediumPojo.setData(multimedium);
            this.multimedia.add(multimediumPojo);
        }
    }
}
