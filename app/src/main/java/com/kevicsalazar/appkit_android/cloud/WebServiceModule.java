package com.kevicsalazar.appkit_android.cloud;

import com.kevicsalazar.appkit_android.cloud.ws.WebServiceItem;
import com.kevicsalazar.appkit_android.utils.AnalyticsProvider;
import com.kevicsalazar.appkit_android.utils.StatusProvider;
import com.kevicsalazar.appkit_java.scopes.PerApp;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
@Module
public class WebServiceModule {

    @Provides
    @PerApp
    @Named("kevicsalazar")
    String provideBaseUrl() {
        return "http://kevicsalazar.parseapp.com";
    }

    @Provides
    @PerApp
    Retrofit provideRetrofit(@Named("kevicsalazar") String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @PerApp
    WebServiceItem.ItemService providePortfolioService(Retrofit retrofit) {
        return retrofit.create(WebServiceItem.ItemService.class);
    }

    @Provides
    @PerApp
    WebServiceItem provideWebServiceItem(WebServiceItem.ItemService service, AnalyticsProvider analytics, StatusProvider status) {
        return new WebServiceItem(service, analytics, status);
    }

}
