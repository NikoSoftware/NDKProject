package com.example.niko.ndkproject.model;

import javax.inject.Inject;

/**
 * title:
 * Created by niko on 2018/5/4
 */


public class A {

    @Inject
    public B b;

    private String value;


    public void setValue(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

}
