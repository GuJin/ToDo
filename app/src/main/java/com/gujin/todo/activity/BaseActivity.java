package com.gujin.todo.activity;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public abstract class BaseActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        initView();
        initData();
        setWindowWidth();
    }

    protected void setWindowWidth() {
        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);
        int width = point.x;

        Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.width = width;
        window.setAttributes(params);
    }

    protected abstract int getContentView();

    protected abstract void initView();

    protected abstract void initData();
}
