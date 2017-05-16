package com.gujin.todo.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.gujin.todo.R;
import com.gujin.todo.constant.SharePerConstant;
import com.gujin.todo.utils.SharedPreUtils;

import tech.gujin.toast.ToastUtil;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private EditText mEditText;
    private String mContent;

    @Override
    public int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mEditText = (EditText) findViewById(R.id.et_content);
    }

    @Override
    protected void initData() {
        setListener();
    }

    private void setListener() {
        findViewById(R.id.btn_add).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                if (!isContentEmpty()) {
                    addNotification();
                    finish();
                } else {
                    ToastUtil.show("内容不能为空");
                }
                break;
        }
    }

    private boolean isContentEmpty() {
        mContent = mEditText.getText().toString().trim();
        return TextUtils.isEmpty(mContent);
    }

    private void addNotification() {
        int id = getId();
        Notification notification = buildNotification(id);
        notification.flags = Notification.FLAG_ONGOING_EVENT;
        NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(id, notification);

        SharedPreUtils.saveInt(SharePerConstant.ID, ++id);
    }

    private Notification buildNotification(int id) {
        Intent intent = new Intent(this, ConfirmActivity.class);
        intent.putExtra(ConfirmActivity.CONTENT, mContent);
        intent.putExtra(ConfirmActivity.ID, id);

        Notification.Builder builder = new Notification.Builder(this).
                setSmallIcon(R.drawable.ic_notific).
                setContentTitle(mContent).
                setContentText("任务完成后请点击").
                setContentIntent(PendingIntent.getActivity(this, id, intent, PendingIntent.FLAG_CANCEL_CURRENT));

        return builder.build();
    }

    private int getId() {
        int id = SharedPreUtils.getInt(SharePerConstant.ID, 0);
        if (id == Integer.MAX_VALUE) {
            id = 0;
        }
        return id;
    }
}