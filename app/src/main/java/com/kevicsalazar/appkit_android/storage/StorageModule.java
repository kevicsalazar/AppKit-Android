package com.kevicsalazar.appkit_android.storage;

import com.kevicsalazar.appkit_android.App;
import com.kevicsalazar.appkit_android.storage.providers.PreferenceProvider;
import com.kevicsalazar.appkit_java.scopes.PerApp;

import dagger.Module;
import dagger.Provides;

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

}
