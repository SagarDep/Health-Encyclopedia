package com.love.cookies.doctor.App;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.love_cookies.cookie_library.Utils.ToastUtils;

import com.love.cookies.doctor.R;

import org.xutils.x;

/**
 * Created by xiekun on 2015/11/25 0025.
 *
 * Application类
 */
public class DoctorApplication extends Application {

    private static Context context;
    private static DoctorApplication instance;

    /**
     * 获取当前的Application
     *
     * @return Application
     */
    public static DoctorApplication getInstance() {
        if (instance == null) {
            instance = new DoctorApplication();
        }
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        context = getApplicationContext();
        checkNetwork();
        x.Ext.init(this);
        x.Ext.setDebug(true);
    }

    //检查网络
    public boolean checkNetwork() {
        if ((!isNetworkConnected(context)) && (!isWifiConnected(context)) && (!isMobileConnected(context))) {
            ToastUtils.show(context, R.string.network_disabled);
            return false;
        } else {
            return true;
        }
    }

    //判断是否有网络连接
    public boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    //判断WIFI网络是否可用
    public boolean isWifiConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mWiFiNetworkInfo = mConnectivityManager
                    .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            if (mWiFiNetworkInfo != null) {
                return mWiFiNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    //判断MOBILE网络是否可用
    public boolean isMobileConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mMobileNetworkInfo = mConnectivityManager
                    .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            if (mMobileNetworkInfo != null) {
                return mMobileNetworkInfo.isAvailable();
            }
        }
        return false;
    }
}
