package com.gujin.todo.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import com.gujin.todo.application.MyApplication;

public class SharedPreUtils {
    private static final String DEFAULT = "NOTIFICATION_ID";
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor edit;

    private static SharedPreferences getSharedPre() {
        if (sharedPreferences == null) {
            sharedPreferences = MyApplication.sContext.getSharedPreferences(DEFAULT, Context.MODE_PRIVATE);
        }
        return sharedPreferences;
    }

    @SuppressLint("CommitPrefEdits")
    private static SharedPreferences.Editor getEdit() {
        if (edit == null) {
            edit = getSharedPre().edit();
        }
        return edit;
    }

    public static void saveInt(String str, int content) {
        getEdit().putInt(str, content).commit();
    }

    public static int getInt(String str, int defaultValue) {
        return getSharedPre().getInt(str, defaultValue);
    }
}
