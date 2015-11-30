package com.kevicsalazar.appkit_android.storage.providers;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.kevicsalazar.appkit_android.App;

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
public class PreferenceProvider {

    private SharedPreferences preferences;

    public PreferenceProvider(App app) {
        preferences = PreferenceManager.getDefaultSharedPreferences(app);
    }

    public boolean getBoolean(String key) {
        return preferences.getBoolean(key, false);
    }

    public boolean getBoolean(String key, boolean defValue) {
        return preferences.getBoolean(key, defValue);
    }

    public void putBoolean(String key, boolean value) {
        preferences.edit().putBoolean(key, value).apply();
    }

    public String getString(String key) {
        return preferences.getString(key, null);
    }

    public String getString(String key, String defValue) {
        return preferences.getString(key, defValue);
    }

    public void putString(String key, String value) {
        preferences.edit().putString(key, value).apply();
    }

    public int getInt(String key) {
        return preferences.getInt(key, 0);
    }

    public int getInt(String key, int defValue) {
        return preferences.getInt(key, defValue);
    }

    public void putInt(String key, int value) {
        preferences.edit().putInt(key, value).apply();
    }

    public long getLong(String key) {
        return preferences.getLong(key, 0);
    }

    public long getLong(String key, long defValue) {
        return preferences.getLong(key, defValue);
    }

    public void putLong(String key, long value) {
        preferences.edit().putLong(key, value).apply();
    }

    public void remove(String key) {
        preferences.edit().remove(key).apply();
    }

    public void clear() {
        preferences.edit().clear().apply();
    }

}
