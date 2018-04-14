package com.nytimes.demo.nytimes.activeandroid;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.nytimes.demo.nytimes.news.models.Multimedium;

/**
 * Created by Samit on 4/14/2018.
 */
@Table(name =" Multimedium" )
public class MultimediumPojo extends Model {
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
}
