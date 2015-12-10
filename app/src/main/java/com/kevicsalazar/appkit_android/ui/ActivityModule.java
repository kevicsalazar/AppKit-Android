package com.kevicsalazar.appkit_android.ui;

import com.kevicsalazar.appkit_android.storage.realm.ItemRealm;
import com.kevicsalazar.appkit_android.ui.adapters.BinderAdapter;
import com.kevicsalazar.appkit_android.ui.mvp.presenters.MainPresenter;
import com.kevicsalazar.appkit_java.scopes.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
@Module
public class ActivityModule {

    @Provides
    @PerActivity
    MainPresenter provideMainPresenter(ItemRealm itemRealm) {
        return new MainPresenter(itemRealm);
    }

    @Provides
    @PerActivity
    BinderAdapter provideBinderAdapter() {
        return new BinderAdapter();
    }

}
