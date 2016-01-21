package com.gujin.todo.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
	private static Toast toast;

	private ToastUtil() {
	}

	public static void show(Context context,String msg) {
		show(context,msg, false);
	}

	public static void show(Context context,String msg, Boolean isLong) {
		if (toast == null) {
			int time = isLong ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT;
			toast = Toast.makeText(context, msg, time);
		} else {
			toast.setText(msg);
		}
		toast.show();
	}
}