package com.kevicsalazar.appkit_android.cloud.ws;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.kevicsalazar.appkit_android.R;
import com.kevicsalazar.appkit_android.ui.mvp.model.Item;
import com.kevicsalazar.appkit_android.utils.AnalyticsProvider;
import com.kevicsalazar.appkit_android.utils.StatusProvider;
import com.kevicsalazar.appkit_java.enums.LoadStatus;
import com.kevicsalazar.appkit_java.interfaces.LoadCallback;

import java.util.ArrayList;
import java.util.List;

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
    private AnalyticsProvider analytics;
    private StatusProvider status;

    public WebServiceItem(ItemService service, AnalyticsProvider analytics, StatusProvider status) {
        this.service = service;
        this.analytics = analytics;
        this.status = status;
    }

    public void getListItems(final LoadCallback<List<Item>> cb) {
        cb.onLoadStatus(LoadStatus.LOADING);
        if (status.isDeviceOnline()) {
            service.listItems().enqueue(new Callback<JsonArray>() {
                @Override
                public void onResponse(Response<JsonArray> response, Retrofit retrofit) {
                    cb.onLoadStatus(LoadStatus.LOADED);
                    if (response.isSuccess()) {
                        List<Item> itemList = new ArrayList<>();
                        JsonArray jsonArray = response.body();
                        for (JsonElement jsonElement : jsonArray) {
                            JsonObject jsonObject = jsonElement.getAsJsonObject();
                            Item item = new Item();
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
                        cb.onLoadSuccess(itemList);
                        analytics.trackEventInBackground("Portafolio", "Request", "Lista de items");
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
