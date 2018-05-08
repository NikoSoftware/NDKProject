package com.example.niko.ndkproject.model;

public class Hello {

    static {
        System.loadLibrary("native-lib");
    }

    public static String sayGoodBye(){

        return "sayGoodBye";
    }

    public static native String sayHello();

    public static native String sayHello(String data);

    public static native String callStaticMethod();


    public static native String callObjectMethod(String data);

    /**
     * java 动态方法
     * @param data
     * @return
     */
    public String sayWord(String data){


        return "\""+data+"\" is from a java instance methon";
    }


}
