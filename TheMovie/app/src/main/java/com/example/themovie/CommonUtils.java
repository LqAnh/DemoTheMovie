package com.example.themovie;

import android.content.Context;
import android.content.SharedPreferences;

public class CommonUtils {
    private static final String PREF_FILE = "pref_file";
    private static CommonUtils instance;

    private CommonUtils() {
        //for singleton
    }

    public static CommonUtils getInstance() {
        if (instance == null) {
            instance = new CommonUtils();
        }
        return instance;
    }






    public void savePref(String key, String value) {
        App.getInstance()
                .getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE)
                .edit().putString(key, value).apply();
    }
    public void clearPref(String key) {
        SharedPreferences pref = App.getInstance().getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);
        pref.edit().remove(key).apply();
    }
    public boolean isExistPref(String key) { // kiem tra ton tai
        SharedPreferences pref = App.getInstance().getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);
        return pref.contains(key);
    }
}
