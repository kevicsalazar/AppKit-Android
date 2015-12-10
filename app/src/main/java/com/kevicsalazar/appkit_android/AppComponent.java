package com.kevicsalazar.appkit_android;

import android.content.Context;

import com.kevicsalazar.appkit_android.cloud.WebServiceModule;
import com.kevicsalazar.appkit_android.cloud.ws.WebServiceItem;
import com.kevicsalazar.appkit_android.storage.StorageModule;
import com.kevicsalazar.appkit_android.storage.preferences.PreferenceProvider;
import com.kevicsalazar.appkit_android.utils.AnalyticsProvider;
import com.kevicsalazar.appkit_android.utils.ResourceProvider;
import com.kevicsalazar.appkit_android.utils.StatusProvider;
import com.kevicsalazar.appkit_java.scopes.PerApp;

import dagger.Component;
import io.realm.Realm;

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
@PerApp
@Component(
        modules = {
                AppModule.class,
                StorageModule.class,
                WebServiceModule.class
        }
)
public interface AppComponent {

    void inject(App app);

    Context provideContext();

    ResourceProvider provideResources();

    PreferenceProvider providePreferences();

    AnalyticsProvider provideAnalytics();

    StatusProvider provideStatus();

    WebServiceItem provideWebServicePortfolio();

    Realm provideDefaultRealm();

}
