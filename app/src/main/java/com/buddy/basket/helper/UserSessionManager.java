package com.buddy.basket.helper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class UserSessionManager {
    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    SharedPreferences.Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "buddyBasket";

    // All Shared Preferences Keys
    public static final String KEY_IS_LOGGED_IN = "isLoggedIn";
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_MOBILE = "mobile";

    public static final String KEY_CITY_ID = "cityId";
    public static final String KEY_CITY_NAME = "cityName";


    @SuppressLint("CommitPrefEdits")
    public UserSessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }


    public  void createLogin(String id, String name, String mobile) {
        editor.putString(KEY_ID, id);
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_MOBILE, mobile);
        editor.putBoolean(KEY_IS_LOGGED_IN, true);
        editor.commit();
    }

    public  void saveLocation(String id, String LocationName) {
        editor.putString(KEY_CITY_ID, id);
        editor.putString(KEY_CITY_NAME, LocationName);
       // editor.putBoolean(KEY_IS_LOGGED_IN, true);
        editor.commit();
    }

    public boolean isLoggedIn() {
        return pref.getBoolean(KEY_IS_LOGGED_IN, false);
    }



    public void clearSession() {
        editor.clear();
        editor.commit();
    }

    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> profile = new HashMap<>();
        profile.put("id", pref.getString(KEY_ID, null));
        profile.put("name", pref.getString(KEY_NAME, null));
        profile.put("mobile", pref.getString(KEY_MOBILE, null));
        return profile;
    }

    public HashMap<String,String> getLocationDetails() {
        HashMap<String, String> location = new HashMap<>();
        location.put("cityId", pref.getString(KEY_CITY_ID, null));
        location.put("cityName", pref.getString(KEY_CITY_NAME, null));
        return location;
    }


}
