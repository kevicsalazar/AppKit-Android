package com.kevicsalazar.appkit_android.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.kevicsalazar.appkit_android.App;

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
public class StatusProvider {

    private App app;

    public StatusProvider(App app) {
        this.app = app;
    }

    public boolean isDeviceOnline() {
        ConnectivityManager connMgr = (ConnectivityManager) app.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }

}
