package com.example.niko.ndkproject.application;

import android.app.Activity;

import com.example.niko.ndkproject.dagger.component.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.DispatchingAndroidInjector;

/**
 * title:
 * Created by niko on 2018/5/5
 */


public class App extends DaggerApplication {


    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return  DaggerAppComponent.builder().application(this).build();
    }
}
