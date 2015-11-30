package com.kevicsalazar.appkit_android;


import android.app.Activity;

import com.kevicsalazar.appkit_android.storage.StorageModule;
import com.kevicsalazar.appkit_android.ui.ActivityComponent;
import com.kevicsalazar.appkit_android.ui.ActivityModule;
import com.kevicsalazar.appkit_android.ui.DaggerActivityComponent;

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
public class Initializer {

    public static AppComponent init(App app) {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(app))
                .storageModule(new StorageModule(app))
                .build();
    }

    public static ActivityComponent init(Activity activity) {
        return DaggerActivityComponent.builder()
                .appComponent(((App) activity.getApplication()).appComponent)
                .activityModule(new ActivityModule())
                .build();
    }

}
