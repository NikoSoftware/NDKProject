# NDKProject
NDK Android demo

### 主要内容

* Java 静态方法 调用C语言方法

* C 语言 调用 Java 静态 方法

* C 语言 调用Java 实例方法

### 示列代码


extern "C" JNIEXPORT jstring JNICALL
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