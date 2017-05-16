package com.gujin.todo.ui;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gujin.todo.R;
import com.gujin.todo.utils.ToastUtil;

public class MainActivity extends BaseActivity {

    private EditText mEditText;
    private Button mButton;
    private String mMsg;

    @Override
    public int getChildContentView() {
        return R.layout.activity_main;
    }

    public void initView() {
        mEditText = getView(R.id.et_main_info);
        mButton = getView(R.id.btn_main_add);
    }

    public void setListener() {
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_main_add:
                mMsg = mEditText.getText().toString().trim();
                if (TextUtils.isEmpty(mMsg)) {
                    ToastUtil.show(MainActivity.this, "内容不能为空");
                    return;
                }
                addNotification();
                break;
        }
    }

    private void addNotification() {
        //获取已添加的待办数量作为ID使用
        int id = mSharePreferenceUtil.getId();
        Intent intent = new Intent(this, ConfirmActivity.class);
        intent.putExtra("msg", mMsg);
        intent.putExtra("id", id);

        Notification.Builder builder = new Notification.Builder(this).
                setSmallIcon(R.drawable.small_icon).
                setContentTitle(mMsg).
                setContentText("任务完成后请点击").
                setContentIntent(PendingIntent.getActivity(this, id, intent, PendingIntent.FLAG_CANCEL_CURRENT));

        Notification notification = builder.getNotification();
        notification.flags = Notification.FLAG_ONGOING_EVENT;
        mNotificationManager.notify(id, notification);
        //更新待办数量
        if (id == 10000) {
            id = 0;
        }
        mSharePreferenceUtil.setId(++id);
        finish();
    }
}