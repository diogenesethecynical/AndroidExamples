#include "com_ankit_example_NDK.h"

JNIEXPORT jint JNICALL Java_com_ankit_example_NDK_add
  (JNIEnv * env, jobject obj, jint a, jint b)
  {
	  return (a+b);
  }
  
  JNIEXPORT jstring JNICALL Java_com_ankit_example_NDK_hello
  (JNIEnv * env, jobject jobj)
  {
	  (*env)->NewStringUTF(env,"This is from native code");
  }
  
	  
	  
	  
