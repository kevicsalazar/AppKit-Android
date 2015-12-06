package com.kevicsalazar.appkit_android.ui;

import com.kevicsalazar.appkit_android.AppComponent;
import com.kevicsalazar.appkit_android.ui.mvp.views.IntroductionFragment;
import com.kevicsalazar.appkit_android.ui.mvp.views.PortfolioFragment;
import com.kevicsalazar.appkit_android.ui.mvp.views.MainActivity;
import com.kevicsalazar.appkit_java.scopes.PerActivity;

import dagger.Component;

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

    void inject(PortfolioFragment fragment);

    void inject(IntroductionFragment fragment);

}
