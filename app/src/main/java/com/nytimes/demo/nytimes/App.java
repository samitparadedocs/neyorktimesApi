package com.nytimes.demo.nytimes;

import android.app.Application;

import com.activeandroid.ActiveAndroid;
import com.facebook.stetho.Stetho;

/**
 * Created by Samit on 4/11/2018.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //Initializing Active Android
        ActiveAndroid.initialize(this);
        Stetho.initializeWithDefaults(this);
    }
}
