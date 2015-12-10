package com.kevicsalazar.appkit_android.storage;

import com.kevicsalazar.appkit_android.App;
import com.kevicsalazar.appkit_android.cloud.ws.WebServiceItem;
import com.kevicsalazar.appkit_android.storage.preferences.PreferenceProvider;
import com.kevicsalazar.appkit_android.storage.realm.ItemRealm;
import com.kevicsalazar.appkit_android.storage.realm.Migration;
import com.kevicsalazar.appkit_java.scopes.PerApp;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
@Module
public class StorageModule {

    private App app;

    public StorageModule(App app) {
        this.app = app;
    }

    @Provides
    @PerApp
    PreferenceProvider providePreferenceProvider() {
        return new PreferenceProvider(app);
    }

    @Provides
    @PerApp
    RealmConfiguration provideRealmConfiguration() {
        return new RealmConfiguration.Builder(app)
                .name("Portfolio.realm")
                .schemaVersion(Migration.SCHEMA_VERSION)
                .migration(new Migration())
                .build();
    }

    @Provides
    @PerApp
    Realm provideDefaultRealm(RealmConfiguration config) {
        return Realm.getInstance(config);
    }

    @Provides
    @PerApp
    ItemRealm provideItemRealm(Realm realm, WebServiceItem ws) {
        return new ItemRealm(realm, ws);
    }

}
