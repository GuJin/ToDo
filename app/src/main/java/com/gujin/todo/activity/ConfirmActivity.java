package com.gujin.todo.activity;

import android.app.NotificationManager;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.gujin.todo.R;

public class ConfirmActivity extends BaseActivity implements View.OnClickListener {

    private TextView mTvContent;

    @Override
    protected int getContentView() {
        return R.layout.activity_confirm;
    }

    @Override
    public void initView() {
        mTvContent = (TextView) findViewById(R.id.tv_content);
    }

    @Override
    protected void initData() {
        setContent();
        setListener();
    }

    private void setContent() {
        mTvContent.setText("已完成 " + getIntent().getStringExtra("msg") + " ?");
    }

    public void setListener() {
        findViewById(R.id.btn_confirm).setOnClickListener(this);
        findViewById(R.id.btn_cancel).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_confirm:
                cancelNotification();
                finish();
                break;
            case R.id.btn_cancel:
                finish();
                break;
        }
    }

    private void cancelNotification() {
        NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancel(getIntent().getIntExtra("id", 0));
    }
}
