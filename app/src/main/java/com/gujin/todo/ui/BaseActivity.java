package com.gujin.todo.ui;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import com.gujin.todo.utils.SharePreferenceUtil;

public abstract class BaseActivity extends Activity implements View.OnClickListener {

    public NotificationManager mNotificationManager;
    public SharePreferenceUtil mSharePreferenceUtil;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getChildContentView());
        initView();
        setListener();
        setMaxWidth();
        setFinishOnTouchOutside(false);
        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mSharePreferenceUtil = new SharePreferenceUtil(this);
    }

    //设置界面宽度
    protected void setMaxWidth() {
        WindowManager manager = getWindowManager();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display display = manager.getDefaultDisplay();
        display.getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = width;
        getWindow().setAttributes(params);
    }

    protected <T extends View> T getView(int id) {
        return (T) findViewById(id);
    }

    public abstract int getChildContentView();

    public abstract void initView();

    public abstract void setListener();
}
