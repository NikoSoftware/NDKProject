#include <jni.h>
#include <string>
#include <android/log.h>


extern "C" JNIEXPORT jstring

JNICALL
Java_com_example_niko_ndkproject_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}




extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_niko_ndkproject_Hello_sayHello(JNIEnv *env, jclass type) {


    // TODO
    return env->NewStringUTF("这是一个文字");

}extern "C"

JNIEXPORT jstring JNICALL
Java_com_example_niko_ndkproject_Hello_sayHello__Ljava_lang_String_2(JNIEnv *env, jclass type,
                                                                   jstring data_) {
    const char *data = env->GetStringUTFChars(data_, 0);

    // TODO

    env->ReleaseStringUTFChars(data_, data);

    return env->NewStringUTF("Hello_sayHello__Ljava");
}


/**
 *
 * C语言调用 Java 静态方法  ，Java静态方法再调用C语言函数 生成返回值
 *
 */
extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_niko_ndkproject_Hello_callStaticMethod(JNIEnv *env, jclass type) {

    // TODO

    jclass cls_hello = env->FindClass("com/example/niko/ndkproject/Hello");

    if(cls_hello==NULL){
        __android_log_print(ANDROID_LOG_DEBUG,"HelloJni","class null");
        return NULL;
    }

    jmethodID  jmethodID1 = env->GetStaticMethodID(cls_hello,"sayHello","()Ljava/lang/String;");

    if(jmethodID1==NULL){
        __android_log_print(ANDROID_LOG_DEBUG,"HelloJni","methon null");
        return NULL;
    }



    jstring data = static_cast<jstring>(env->CallStaticObjectMethod(cls_hello, jmethodID1));

    env->DeleteLocalRef(cls_hello);

    return data;
}
