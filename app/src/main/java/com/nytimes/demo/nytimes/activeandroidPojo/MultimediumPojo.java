package com.nytimes.demo.nytimes.activeandroidPojo;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.nytimes.demo.nytimes.news.models.Multimedium;

import java.io.Serializable;

/**
 * Created by Samit
 * on 4/14/2018.
 */
@Table(name =" Multimedium" )
public class MultimediumPojo extends Model implements Serializable {
    private long localId;
    @Column
    private String url;
    @Column
    private String format;
    @Column
    private int height;
    @Column
    private int width;
    @Column
    private String type;
    @Column
    private String subtype;
    @Column
    private String caption;
    @Column
    private String copyright;
    @Column
    private long mappingId;

    public long getLocalId() {
        return localId;
    }

    public void setLocalId(long localId) {
        this.localId = localId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public void setData(Multimedium multimedium) {
        url=multimedium.url;

        format=multimedium.copyright;

        height=multimedium.height;

         width=multimedium.width;

        type=multimedium.type;

        subtype=multimedium.subtype;

        caption=multimedium.caption;

        copyright=multimedium.copyright;
    }

    public long getMappingId() {
        return mappingId;
    }

    public void setMappingId(long mappingId) {
        this.mappingId = mappingId;
    }
}
