package com.kevicsalazar.appkit_android;

import android.support.multidex.MultiDexApplication;

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
public class App extends MultiDexApplication {

    public AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = Initializer.init(this);
        setupComponent();
    }

    public void setupComponent() {
        appComponent.inject(this);
    }

}
