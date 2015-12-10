package com.kevicsalazar.appkit_android.storage.realm;

import io.realm.DynamicRealm;
import io.realm.RealmMigration;

public class Migration implements RealmMigration {

    public static final long SCHEMA_VERSION = 1;

    @Override
    public void migrate(DynamicRealm dynamicRealm, long oldVersion, long newVersion) {

    }
}
