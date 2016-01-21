package com.gujin.todo.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gujin.todo.R;

public class ConfirmActivity extends BaseActivity {

    private TextView mTextView;
    private Button mButtonYes;
    private Button mButtonNo;
    private String mMsg;
    private int mId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMsg = getIntent().getStringExtra("msg");
        mId = getIntent().getIntExtra("id", 0);
        mTextView.setText("已完成 " + mMsg + " ?");
    }

    @Override
    public int getChildContentView() {
        return R.layout.activity_confirm;
    }

    @Override
    public void initView() {
        mTextView = getView(R.id.tv_confirm_hint);
        mButtonYes = getView(R.id.btn_confirm_yes);
        mButtonNo = getView(R.id.btn_confirm_no);
    }

    @Override
    public void setListener() {
        mButtonYes.setOnClickListener(this);
        mButtonNo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_confirm_yes:
                mNotificationManager.cancel(mId);
                finish();
                break;
            case R.id.btn_confirm_no:
                finish();
                break;
        }
    }
}
