package com.example.niko.ndkproject.dagger.module;

import com.example.niko.ndkproject.activity.DaggerTestActivity;
import com.example.niko.ndkproject.dagger.ActivityScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * title:
 * Created by niko on 2018/5/5
 */

@Module
public abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract DaggerTestActivity daggerTestActivityInject();


}
