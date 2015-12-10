package com.kevicsalazar.appkit_android.storage.realm;

import com.kevicsalazar.appkit_android.cloud.ws.WebServiceItem;
import com.kevicsalazar.appkit_android.ui.mvp.model.Item;
import com.kevicsalazar.appkit_java.interfaces.LoadCallback;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;

/**
 * Created by Kevin Salazar
 */
public class ItemRealm {

    private Realm realm;
    private WebServiceItem ws;

    public ItemRealm(Realm realm, WebServiceItem ws) {
        this.realm = realm;
        this.ws = ws;
    }

    public void getListItems(LoadCallback<List<Item>> cb) {
        if (ws.isTimeToUpdate()) {
            ws.getListItems(cb);
        } else {
            RealmQuery<Item> query = realm.where(Item.class);
            cb.onLoadSuccess(query.findAll());
        }
    }

}
