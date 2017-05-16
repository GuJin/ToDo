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

    public static void saveString(String str, String content) {
        getEdit().putString(str, content).commit();
    }

    public static void saveInt(String str, int content) {
        getEdit().putInt(str, content).commit();
    }

    public static void saveDouble(String str, double content) {
        getEdit().putFloat(str, (float) content).commit();
    }

    public static void saveLong(String str, long content) {
        getEdit().putLong(str, content).commit();
    }

    public static void saveBoolean(String str, Boolean content) {
        getEdit().putBoolean(str, content).commit();
    }

    public static boolean getBoolean(String str, boolean defaultValue) {
        return getSharedPre().getBoolean(str, defaultValue);
    }

    public static String getString(String str, String defaultValue) {
        return getSharedPre().getString(str, defaultValue);
    }

    /**
     * 获取int类型值
     */
    public static int getInt(String str, int defaultValue) {
        return getSharedPre().getInt(str, defaultValue);
    }

    /**
     * 获取double类型值
     */
    public static double getDouble(String str, double defaultValue) {
        return getSharedPre().getFloat(str, (float) defaultValue);
    }

    /**
     * 获取long类型值
     */
    public static long getLong(String str, long defaultValue) {
        return getSharedPre().getLong(str, defaultValue);
    }
}
