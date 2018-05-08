package com.example.niko.ndkproject.dagger.component;

import android.app.Application;

import com.example.niko.ndkproject.application.App;
import com.example.niko.ndkproject.dagger.module.ABCDModule;
import com.example.niko.ndkproject.dagger.module.ActivityBuilderModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * title:
 * Created by niko on 2018/5/5
 */

@Singleton
@Component(modules = {AndroidInjectionModule.class,
        ActivityBuilderModule.class, ABCDModule.class})
public interface AppComponent extends AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }

}
