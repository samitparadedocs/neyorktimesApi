package com.nytimes.demo.nytimes.news.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Result implements Serializable {

@SerializedName("slug_name")
@Expose
public String slugName;
@SerializedName("section")
@Expose
public String section;
@SerializedName("subsection")
@Expose
public String subsection;
@SerializedName("title")
@Expose
public String title;
@SerializedName("abstract")
@Expose
public String _abstract;
@SerializedName("url")
@Expose
public String url;
@SerializedName("byline")
@Expose
public String byline;
@SerializedName("thumbnail_standard")
@Expose
public String thumbnailStandard;
@SerializedName("item_type")
@Expose
public String itemType;
@SerializedName("source")
@Expose
public String source;
@SerializedName("updated_date")
@Expose
public String updatedDate;
@SerializedName("created_date")
@Expose
public String createdDate;
@SerializedName("published_date")
@Expose
public String publishedDate;
@SerializedName("first_published_date")
@Expose
public String firstPublishedDate;
@SerializedName("material_type_facet")
@Expose
public String materialTypeFacet;
@SerializedName("kicker")
@Expose
public String kicker;
@SerializedName("subheadline")
@Expose
public String subheadline;
@SerializedName("des_facet")
@Expose
public List<String> desFacet = null;
@SerializedName("org_facet")
@Expose
public List<String> orgFacet = null;
@SerializedName("per_facet")
@Expose
public List<String> perFacet = null;

@SerializedName("geo_facet")
@Expose
public List<String> geoFacet;
@SerializedName("related_urls")
@Expose
public String relatedUrls;
@SerializedName("multimedia")
@Expose
public List<Multimedium> multimedia = null;

public String getSlugName() {
return slugName;
}

public void setSlugName(String slugName) {
this.slugName = slugName;
}

public String getSection() {
return section;
}

public void setSection(String section) {
this.section = section;
}

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

public String getAbstract() {
return _abstract;
}

public void setAbstract(String _abstract) {
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

public List<Multimedium> getMultimedia() {
return multimedia;
}

public void setMultimedia(List<Multimedium> multimedia) {
this.multimedia = multimedia;
}

    @Override
    public String toString() {
        return "Result{" +
                "slugName='" + slugName + '\'' +
                ", section='" + section + '\'' +
                ", subsection='" + subsection + '\'' +
                ", title='" + title + '\'' +
                ", _abstract='" + _abstract + '\'' +
                ", url='" + url + '\'' +
                ", byline='" + byline + '\'' +
                ", thumbnailStandard='" + thumbnailStandard + '\'' +
                ", itemType='" + itemType + '\'' +
                ", source='" + source + '\'' +
                ", updatedDate='" + updatedDate + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", publishedDate='" + publishedDate + '\'' +
                ", firstPublishedDate='" + firstPublishedDate + '\'' +
                ", materialTypeFacet='" + materialTypeFacet + '\'' +
                ", kicker='" + kicker + '\'' +
                ", subheadline='" + subheadline + '\'' +
                ", desFacet=" + desFacet +
                ", orgFacet=" + orgFacet +
                ", perFacet=" + perFacet +
                ", geoFacet=" + geoFacet +
                ", relatedUrls='" + relatedUrls + '\'' +
                ", multimedia=" + multimedia +
                '}';
    }
}

