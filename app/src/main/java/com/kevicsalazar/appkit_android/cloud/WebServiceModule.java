package com.kevicsalazar.appkit_android.cloud;

import com.kevicsalazar.appkit_android.cloud.ws.WebServiceProject;
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
    WebServiceProject.ProjectService providePortfolioService(Retrofit retrofit) {
        return retrofit.create(WebServiceProject.ProjectService.class);
    }

    @Provides
    @PerApp
    WebServiceProject provideWebServiceProject(WebServiceProject.ProjectService service) {
        return new WebServiceProject(service);
    }

}
