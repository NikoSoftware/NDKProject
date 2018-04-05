package com.example.niko.ndkproject;

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


}
