package com.kevicsalazar.appkit_android.utils;

import android.content.res.ColorStateList;
import android.support.v4.content.ContextCompat;

import com.kevicsalazar.appkit_android.App;

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
public class ResourceProvider {

    private App app;

    public ResourceProvider(App app) {
        this.app = app;
    }

    public String getString(int resId){
        return app.getResources().getString(resId);
    }

    public int getColor(int resId){
        return ContextCompat.getColor(app, resId);
    }

    public ColorStateList getColorStateList(int resId){
        return ContextCompat.getColorStateList(app, resId);
    }

}
