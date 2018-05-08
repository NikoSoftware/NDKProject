package com.example.niko.ndkproject.model;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * title:
 * Created by niko on 2018/5/4
 */

@Singleton
public class B {

    private String key = "测试K";

    @Inject
    public B(){

    }

    public String getKey(){


        return key;
    }

    public String getClassName(){

        return this.getClassName();
    }


}
