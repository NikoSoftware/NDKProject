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
    //获取 Java 类文件
    jclass cls_hello = env->FindClass("com/example/niko/ndkproject/Hello");

    if(cls_hello==NULL){
        __android_log_print(ANDROID_LOG_DEBUG,"HelloJni","class null");
        return NULL;
    }

    //静态方法ID
    jmethodID  jmethodID1 = env->GetStaticMethodID(cls_hello,"sayHello","()Ljava/lang/String;");

    if(jmethodID1==NULL){
        __android_log_print(ANDROID_LOG_DEBUG,"HelloJni","methon null");
        return NULL;
    }



    jstring data = static_cast<jstring>(env->CallStaticObjectMethod(cls_hello, jmethodID1));

    env->DeleteLocalRef(cls_hello);

    return data;
}
extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_niko_ndkproject_Hello_callObjectMethod(JNIEnv *env, jclass type, jstring data_) {
    const char *data = env->GetStringUTFChars(data_, 0);

    //获取 Java 类文件
    jclass  jclass1 = env->FindClass("com/example/niko/ndkproject/Hello");
    if(jclass1==NULL){
        return NULL;
    }


    //实列方法
    jmethodID jmethodID1 = env->GetMethodID(jclass1,"sayWord","(Ljava/lang/String;)Ljava/lang/String;");


    //构造方法
    jmethodID jmethodID_construct = env->GetMethodID(jclass1,"<init>","()V");
    if(jmethodID_construct==NULL){
        return NULL;
    }

    //生成 Java 对象
    jobject  jobject1 = env->NewObject(jclass1,jmethodID_construct,NULL);

    if(jobject1==NULL){
        return NULL;
    }

    // 执行实例方法
    jstring jstring1 = static_cast<jstring>(env->CallObjectMethod(jobject1, jmethodID1, data_));

    env->DeleteLocalRef(jclass1);
    env->DeleteLocalRef(jobject1);

    return jstring1;
}