package com.example.niko.ndkproject.dagger.module;

import com.example.niko.ndkproject.model.A;
import com.example.niko.ndkproject.model.B;
import com.example.niko.ndkproject.model.C;

import dagger.Module;
import dagger.Provides;

/**
 * title:
 * Created by niko on 2018/5/7
 */

@Module
public class ABCDModule {


    @Provides
    public C privideC(B b){

        return new C(b);
    }

    @Provides
    public A privideA(){

        return new A();
    }



}
