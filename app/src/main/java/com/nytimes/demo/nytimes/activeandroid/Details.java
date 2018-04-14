package com.nytimes.demo.nytimes.activeandroid;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;


@Table(name = "Details")
public class Details extends Model {

    @Column(name = "Name")
    public String name;

    @Column(name = "Age")
    public String age;

}