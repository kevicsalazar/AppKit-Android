package com.kevicsalazar.appkit_android.utils;

import android.support.annotation.NonNull;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.kevicsalazar.appkit_android.App;
import com.kevicsalazar.appkit_android.BuildConfig;

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
public class AnalyticsProvider {

    private Tracker tracker;

    public AnalyticsProvider(App app) {
        GoogleAnalytics analytics = GoogleAnalytics.getInstance(app);
        analytics.setLocalDispatchPeriod(1800);
        tracker = analytics.newTracker(BuildConfig.GOOGLE_TRACKING_ID);
        tracker.enableAdvertisingIdCollection(true);
    }

    public void signUpInBackground(@NonNull String code) {
        tracker.set("&uid", code);
    }

    public void trackScreenNameInBackground(@NonNull String name) {
        tracker.setScreenName(name);
        tracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    public void trackEventInBackground(String category, String action, String label) {
        tracker.send(new HitBuilders.EventBuilder()
                .setCategory(category)
                .setAction(action)
                .setLabel(label)
                .build());
    }

}
