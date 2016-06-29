package com.love.cookies.health_encyclopedia.Receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.love_cookies.cookie_library.Utils.ToastUtils;

import com.love.cookies.health_encyclopedia.R;

/**
 * Created by xiekun on 2015/11/25 0025.
 *
 * 网络监听器
 */
public class NetWorkReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mobileInfo = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        NetworkInfo wifiInfo = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo activeInfo = manager.getActiveNetworkInfo();
        if(activeInfo != null) {
//            Toast.makeText(context, "mobile:" + mobileInfo.isConnected() + "\n" + "wifi:" + wifiInfo.isConnected()
//                    + "\n" + "active:" + activeInfo.getTypeName(), Toast.LENGTH_SHORT).show();
        }else{
            ToastUtils.show(context, R.string.network_disabled);
        }
    }  //activeInfo为null即是无网络

}