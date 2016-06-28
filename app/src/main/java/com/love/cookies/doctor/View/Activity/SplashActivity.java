package com.love.cookies.doctor.View.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;

import com.love_cookies.cookie_library.Activity.BaseActivity;

import com.love.cookies.doctor.R;

import org.xutils.view.annotation.ContentView;

/**
 * Created by xiekun on 2015/11/24 0024.
 *
 * App启动Activity
 */
@ContentView(R.layout.activity_splash)
public class SplashActivity extends BaseActivity {

	private final int SPLASH_DISPLAY_LENGHT = 1500;
	Looper looper = Looper.myLooper();
	private Handler handler = new Handler(looper);

	Runnable runnable = new Runnable() {
		@Override
		public void run() {
			Intent intent = new Intent(SplashActivity.this, MainActivity.class);
			startActivity(intent);
			finish();
		}
	};

	@Override
	public void initWidget(Bundle savedInstanceState) {
		handler.postDelayed(runnable, SPLASH_DISPLAY_LENGHT);
	}

	@Override
	public void widgetClick(View v) {

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			handler.removeCallbacks(runnable);
		}
		return super.onKeyDown(keyCode, event);
	}
}
