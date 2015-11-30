package com.kevicsalazar.appkit_android;

import android.app.Application;
import android.content.Context;

import com.kevicsalazar.appkit_android.utils.AnalyticsProvider;
import com.kevicsalazar.appkit_android.utils.ResourceProvider;
import com.kevicsalazar.appkit_android.utils.StatusProvider;
import com.kevicsalazar.appkit_java.scopes.PerApp;

import dagger.Module;
import dagger.Provides;

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
@Module
public class AppModule {

    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    @PerApp
    Context provideContext() {
        return app;
    }

    @Provides
    @PerApp
    Application provideApplication() {
        return app;
    }

    @Provides
    @PerApp
    ResourceProvider provideResources() {
        return new ResourceProvider(app);
    }

    @Provides
    @PerApp
    AnalyticsProvider provideAnalytics() {
        return new AnalyticsProvider(app);
    }

    @Provides
    @PerApp
    StatusProvider provideStatus() {
        return new StatusProvider(app);
    }

}
