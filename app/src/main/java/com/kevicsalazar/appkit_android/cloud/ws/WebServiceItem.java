package com.kevicsalazar.appkit_android.cloud.ws;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.kevicsalazar.appkit_android.R;
import com.kevicsalazar.appkit_android.storage.preferences.PreferenceProvider;
import com.kevicsalazar.appkit_android.ui.mvp.model.Item;
import com.kevicsalazar.appkit_android.utils.AnalyticsProvider;
import com.kevicsalazar.appkit_android.utils.StatusProvider;
import com.kevicsalazar.appkit_java.enums.LoadStatus;
import com.kevicsalazar.appkit_java.interfaces.LoadCallback;
import com.kevicsalazar.appkit_java.utils.UpdateTime;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.realm.Realm;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.GET;

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
public class WebServiceItem {

    private ItemService service;
    private Realm realm;
    private PreferenceProvider pref;
    private AnalyticsProvider analytics;
    private StatusProvider status;

    private UpdateTime updateTime = UpdateTime.AUTOMED;

    public boolean isTimeToUpdate() {
        return updateTime.isTimeToUpdate(pref.getLong("ListItem", 0));
    }

    public WebServiceItem(ItemService service, Realm realm, PreferenceProvider pref, AnalyticsProvider analytics, StatusProvider status) {
        this.service = service;
        this.realm = realm;
        this.pref = pref;
        this.analytics = analytics;
        this.status = status;
    }

    public void getListItems(final LoadCallback<List<Item>> cb) {
        cb.onLoadStatus(LoadStatus.LOADING);
        if (status.isDeviceOnline()) {
            service.listItems().enqueue(new Callback<JsonArray>() {
                @Override
                public void onResponse(final Response<JsonArray> response, Retrofit retrofit) {
                    cb.onLoadStatus(LoadStatus.LOADED);
                    if (response.isSuccess()) {
                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                List<Item> itemList = new ArrayList<>();
                                JsonArray jsonArray = response.body();
                                for (JsonElement jsonElement : jsonArray) {
                                    JsonObject jsonObject = jsonElement.getAsJsonObject();
                                    Item item = new Item();
                                    item.setId(jsonObject.get("objectId").getAsString());
                                    item.setTitle(jsonObject.get("title").getAsString());
                                    item.setDescription(jsonObject.get("description").getAsString());
                                    item.setOcupation(jsonObject.get("ocupation").getAsString());
                                    item.setPeriod(jsonObject.get("period").getAsString().replaceAll(" - ", "\n"));
                                    item.setAddress(jsonObject.get("address").getAsString());
                                    item.setMarker(jsonObject.get("marker").getAsString());
                                    item.setLink(jsonObject.get("link").getAsString());
                                    item.setPosition(jsonObject.get("position").getAsInt());
                                    itemList.add(item);
                                }
                                realm.copyToRealmOrUpdate(itemList);
                                analytics.trackEventInBackground("Portafolio", "Request", "Lista de items");
                                pref.putLong("ListItem", new Date().getTime());
                                cb.onLoadSuccess(itemList);
                            }
                        });
                    }
                }

                @Override
                public void onFailure(Throwable t) {
                    t.printStackTrace();
                    cb.onLoadStatus(LoadStatus.LOADED);
                    cb.onLoadFailure(R.string.unknow_error);
                }
            });
        } else {
            cb.onLoadStatus(LoadStatus.LOADED);
            cb.onLoadFailure(R.string.network_error);
        }
    }

    public interface ItemService {

        @GET("/service/listItems")
        Call<JsonArray> listItems();

    }

}
