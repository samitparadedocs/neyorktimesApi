package com.nytimes.demo.nytimes.activeandroidPojo;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.nytimes.demo.nytimes.news.models.Multimedium;
import com.nytimes.demo.nytimes.news.models.Result;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Samit on 4/13/2018.
 */
@Table(name = "Results")
public class ResultPojo extends Model implements Serializable {
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

    public String getSubsection() {
        return subsection;
    }

    public void setSubsection(String subsection) {
        this.subsection = subsection;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String get_abstract() {
        return _abstract;
    }

    public void set_abstract(String _abstract) {
        this._abstract = _abstract;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getThumbnailStandard() {
        return thumbnailStandard;
    }

    public void setThumbnailStandard(String thumbnailStandard) {
        this.thumbnailStandard = thumbnailStandard;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getFirstPublishedDate() {
        return firstPublishedDate;
    }

    public void setFirstPublishedDate(String firstPublishedDate) {
        this.firstPublishedDate = firstPublishedDate;
    }

    public String getMaterialTypeFacet() {
        return materialTypeFacet;
    }

    public void setMaterialTypeFacet(String materialTypeFacet) {
        this.materialTypeFacet = materialTypeFacet;
    }

    public String getKicker() {
        return kicker;
    }

    public void setKicker(String kicker) {
        this.kicker = kicker;
    }

    public String getSubheadline() {
        return subheadline;
    }

    public void setSubheadline(String subheadline) {
        this.subheadline = subheadline;
    }

    public List<String> getDesFacet() {
        return desFacet;
    }

    public void setDesFacet(List<String> desFacet) {
        this.desFacet = desFacet;
    }

    public List<String> getOrgFacet() {
        return orgFacet;
    }

    public void setOrgFacet(List<String> orgFacet) {
        this.orgFacet = orgFacet;
    }

    public List<String> getPerFacet() {
        return perFacet;
    }

    public void setPerFacet(List<String> perFacet) {
        this.perFacet = perFacet;
    }

    public List<String> getGeoFacet() {
        return geoFacet;
    }

    public void setGeoFacet(List<String> geoFacet) {
        this.geoFacet = geoFacet;
    }

    public String getRelatedUrls() {
        return relatedUrls;
    }

    public void setRelatedUrls(String relatedUrls) {
        this.relatedUrls = relatedUrls;
    }

    public List<MultimediumPojo> getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(List<MultimediumPojo> multimedia) {
        this.multimedia = multimedia;
    }

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

    public List<MultimediumPojo> getMutimediumList() {
            return new Select().all()
                .from(MultimediumPojo.class)
                .where("mappingId = ?", getId())
                .orderBy("id ASC")
                .execute();
    }

    // Read all Data
    public static List<ResultPojo> getResultPojoSelectAll() {
        return new Select()
                .from(ResultPojo.class)
                .orderBy("id ASC")
                .execute();
    }

    public static List<ResultPojo> getResultMultiMediaMapping() {
        List<ResultPojo> getAll= getResultPojoSelectAll();
        for (ResultPojo resultPojo : getAll) {
            resultPojo.multimedia=resultPojo.getMutimediumList();
        }
        return getAll;
    }
}
