package com.gujin.todo.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePreferenceUtil {
    private final String notificationId = "NOTIFICATION_ID";
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    public SharePreferenceUtil(Context context) {
        sp = context.getSharedPreferences(notificationId, Context.MODE_PRIVATE);
        editor = sp.edit();
    }

    public int getId() {
        return sp.getInt("id", 0);
    }

    public void setId(int id) {
        editor.putInt("id", id);
        editor.commit();
    }
}
