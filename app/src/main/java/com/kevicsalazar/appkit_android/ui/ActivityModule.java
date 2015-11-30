package com.kevicsalazar.appkit_android.ui;

import com.kevicsalazar.appkit_android.cloud.ws.WebServiceProject;
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
    MainPresenter provideMainPresenter(WebServiceProject service) {
        return new MainPresenter(service);
    }

    @Provides
    @PerActivity
    BinderAdapter provideBinderAdapter() {
        return new BinderAdapter();
    }

}
