package com.example.niko.ndkproject.model;

import dagger.Module;

/**
 * title:
 * Created by niko on 2018/5/7
 */

public class C {

    private B b;
    public C(B b){
        this.b = b;
    }



    public B getB(){
        return b;
    }

}
