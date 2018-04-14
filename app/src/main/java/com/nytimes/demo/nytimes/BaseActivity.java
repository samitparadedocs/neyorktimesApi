package com.nytimes.demo.nytimes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import com.nytimes.demo.nytimes.deps.DaggerDeps;
import com.nytimes.demo.nytimes.deps.Deps;
import com.nytimes.demo.nytimes.networking.NetworkModule;

import java.io.File;

public class BaseActivity extends AppCompatActivity {
    Deps deps;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        File cacheFile = new File(getCacheDir(), "responses");
        deps = DaggerDeps.builder().networkModule(new NetworkModule(cacheFile)).build();

    }

    public Deps getDeps() {
        return deps;
    }
}