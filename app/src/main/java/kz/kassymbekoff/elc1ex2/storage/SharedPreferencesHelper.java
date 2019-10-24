package kz.kassymbekoff.elc1ex2.storage;

import android.content.Context;
import android.content.SharedPreferences;


public class SharedPreferencesHelper {
    public static final String SHARED_PREF_NAME = "SHARED_PREF_NAME";

    public static final String SEARCH_KEY = "CHECKED_SEARCH_KEY";

    private SharedPreferences mSharedPreferences;

    public SharedPreferencesHelper(Context context) {
        mSharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
    }

    public boolean addChecked(String checkedSystem) {
        mSharedPreferences.edit().putString(SEARCH_KEY, checkedSystem).apply();
        return true;
    }

    public String getSelectedSystem(){
        return mSharedPreferences.getString(SEARCH_KEY, null);
    }
}
