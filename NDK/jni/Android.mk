LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := ndk_demo
LOCAL_SRC_FILES := ndk_demo.c

include $(BUILD_SHARED_LIBRARY)
