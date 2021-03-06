package com.gujin.todo.application;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import tech.gujin.toast.ToastUtil;

public class MyApplication extends Application {
    @SuppressLint("StaticFieldLeak")
    public static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
        ToastUtil.initialize(sContext, ToastUtil.Mode.REPLACEABLE);
    }
}